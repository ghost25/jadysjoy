/**
 * 
 */
package com.dabis.trimsalon.dao.base;

import java.io.Serializable;

/**
 * @author Tom
 *
 */
public interface IGenericDao <T, PK extends Serializable> {

    /** Persist the newInstance object into database
     *  Returns the Id of the created instance.
     */
    PK create(T newInstance);

    /** Retrieve an object that was previously persisted to the database using
     *   the indicated id as primary key
     */
    T read(PK id);

    /** Save changes made to a persistent object.  */
    void update(T transientObject);

    /** Remove an object from persistent storage in the database */
    void delete(T persistentObject);
}

