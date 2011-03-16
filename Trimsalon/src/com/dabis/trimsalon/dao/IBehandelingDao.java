package com.dabis.trimsalon.dao;

import java.util.List;

import com.dabis.trimsalon.dao.base.IGenericDao;
import com.dabis.trimsalon.beans.Behandeling;

public interface IBehandelingDao extends IGenericDao<Behandeling, Long>
{
    List<Behandeling> findAll();
}
