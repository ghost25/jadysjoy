package com.dabis.trimsalon.dao.base;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

/**
 * Connects the Spring AOP magic with the Hibernate DAO magic
 * For any method beginning with "find" this interceptor will use the FinderExecutor to call a Hibernate named query
 */
public class FinderIntroductionInterceptor implements IntroductionInterceptor
{

    @SuppressWarnings("rawtypes")
	public Object invoke(MethodInvocation methodInvocation) throws Throwable
    {

        IFinderExecutor executor = (IFinderExecutor) methodInvocation.getThis();

        String methodName = methodInvocation.getMethod().getName();
        if(methodName.startsWith("find") || methodName.startsWith("list"))
        {
            Object[] arguments = methodInvocation.getArguments();
            return executor.executeFinder(methodInvocation.getMethod(), arguments);
        }
        else if(methodName.startsWith("iterate"))
        {
            Object[] arguments = methodInvocation.getArguments();
            return executor.iterateFinder(methodInvocation.getMethod(), arguments);
        }
//        else if(methodName.startsWith("scroll"))
//        {
//            Object[] arguments = methodInvocation.getArguments();
//            return executor.scrollFinder(methodInvocation.getMethod(), arguments);
//        }
        else
        {
            return methodInvocation.proceed();
        }
    }

    @SuppressWarnings("rawtypes")
	public boolean implementsInterface(Class intf)
    {
        return intf.isInterface() && IFinderExecutor.class.isAssignableFrom(intf);
    }
}
