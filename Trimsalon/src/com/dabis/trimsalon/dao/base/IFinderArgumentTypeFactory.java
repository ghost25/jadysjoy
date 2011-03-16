package com.dabis.trimsalon.dao.base;

import org.hibernate.type.Type;

/**
 * Used to locate any specific type mappings that might be necessary for a dao implementation
 */
public interface IFinderArgumentTypeFactory
{
    Type getArgumentType(Object arg);
}
