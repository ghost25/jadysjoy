package com.dabis.trimsalon.dao.base;

import org.hibernate.type.Type;

/**
 * Maps Enums to a custom Hibernate user type
 */
public class SimpleFinderArgumentTypeFactory implements IFinderArgumentTypeFactory
{
    public Type getArgumentType(Object arg)
    {
//        if(arg instanceof Enum)
//        {
//            return getEnumType(arg.getClass());
//        }
//        else
//        {
            return null;
//        }
    }

//    private Type getEnumType(Class<? extends Object> argClass)
//    {
//        Properties p = new Properties();
//        p.setProperty("enumClassName", argClass.getName());
//        Type enumType = TypeFactory.heuristicType("org.hibernate.demo.EnumUserType", p);
//        return enumType;
//    }
}
