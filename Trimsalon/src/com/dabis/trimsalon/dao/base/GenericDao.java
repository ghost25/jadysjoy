package com.dabis.trimsalon.dao.base;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

/**
 * Background info: http://www.ibm.com/developerworks/java/library/j-genericdao.html
 * 
 * Hibernate implementation of GenericDao
 * A typesafe implementation of CRUD and finder methods based on Hibernate and Spring AOP
 * The finders are implemented through the executeFinder method.
 * Normally called by the FinderIntroductionInterceptor.
 */
@SuppressWarnings("rawtypes")
public class GenericDao<T, PK extends Serializable> implements IGenericDao<T, PK>, IFinderExecutor
{
    private SessionFactory sessionFactory;
    private IFinderNamingStrategy namingStrategy = new SimpleFinderNamingStrategy(); // Default. Can override in config
    private IFinderArgumentTypeFactory argumentTypeFactory = new SimpleFinderArgumentTypeFactory(); // Default. Can override in config

    private Class<T> type;

    public GenericDao(Class<T> type)
    {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
	public PK create(T o)
    {
        return (PK) getSession().save(o);
    }

    @SuppressWarnings("unchecked")
	public T read(PK id)
    {
        return (T) getSession().get(type, id);
    }

    public void update(T o)
    {
        getSession().update(o);
    }

    public void delete(T o)
    {
        getSession().delete(o);
    }

    @SuppressWarnings("unchecked")
	public List<T> executeFinder(Method method, final Object[] queryArgs)
    {
        final Query namedQuery = prepareQuery(method, queryArgs);
        return (List<T>) namedQuery.list();
    }

    @SuppressWarnings("unchecked")
	public Iterator<T> iterateFinder(Method method, final Object[] queryArgs)
    {
        final Query namedQuery = prepareQuery(method, queryArgs);
        return (Iterator<T>) namedQuery.iterate();
    }

//    public ScrollableResults scrollFinder(Method method, final Object[] queryArgs)
//    {
//        final Query namedQuery = prepareQuery(method, queryArgs);
//        return (ScrollableResults) namedQuery.scroll();
//    }

    private Query prepareQuery(Method method, Object[] queryArgs)
    {
        final String queryName = getNamingStrategy().queryNameFromMethod(type, method);
        final Query namedQuery = getSession().getNamedQuery(queryName);
        String[] namedParameters = namedQuery.getNamedParameters();
        if(namedParameters.length==0)
        {
            setPositionalParams(queryArgs, namedQuery);
        } else {
            setNamedParams(namedParameters, queryArgs, namedQuery);
        }
        return namedQuery;
    }

    private void setPositionalParams(Object[] queryArgs, Query namedQuery)
    {
        // Set parameter. Use custom Hibernate Type if necessary
        if(queryArgs!=null)
        {
            for(int i = 0; i < queryArgs.length; i++)
            {
                Object arg = queryArgs[i];
                Type argType = getArgumentTypeFactory().getArgumentType(arg);
                if(argType != null)
                {
                    namedQuery.setParameter(i, arg, argType);
                }
                else
                {
                    namedQuery.setParameter(i, arg);
                }
            }
        }
    }

    private void setNamedParams(String[] namedParameters, Object[] queryArgs, Query namedQuery)
    {
        // Set parameter. Use custom Hibernate Type if necessary
        if(queryArgs!=null)
        {
            for(int i = 0; i < queryArgs.length; i++)
            {
                Object arg = queryArgs[i];
                Type argType = getArgumentTypeFactory().getArgumentType(arg);
                if(argType != null)
                {
                    namedQuery.setParameter(namedParameters[i], arg, argType);
                }
                else
                {
                    if(arg instanceof Collection) {
                        namedQuery.setParameterList(namedParameters[i], (Collection) arg);
                    }
                    else
                    {
                        namedQuery.setParameter(namedParameters[i], arg);
                    }
                }
            }
        }
    }

    public Session getSession()
    {
        boolean allowCreate = true;
        return SessionFactoryUtils.getSession(sessionFactory, allowCreate);
    }

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    public IFinderNamingStrategy getNamingStrategy()
    {
        return namingStrategy;
    }

    public void setNamingStrategy(IFinderNamingStrategy namingStrategy)
    {
        this.namingStrategy = namingStrategy;
    }

    public IFinderArgumentTypeFactory getArgumentTypeFactory()
    {
        return argumentTypeFactory;
    }

    public void setArgumentTypeFactory(IFinderArgumentTypeFactory argumentTypeFactory)
    {
        this.argumentTypeFactory = argumentTypeFactory;
    }
}
