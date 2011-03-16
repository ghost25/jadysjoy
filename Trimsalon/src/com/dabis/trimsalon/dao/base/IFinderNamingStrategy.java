package com.dabis.trimsalon.dao.base;

import java.lang.reflect.Method;

/**
 * Used to locate a named query based on the called finder method
 */
public interface IFinderNamingStrategy
{
    @SuppressWarnings("rawtypes")
	public String queryNameFromMethod(Class findTargetType, Method finderMethod);
}
