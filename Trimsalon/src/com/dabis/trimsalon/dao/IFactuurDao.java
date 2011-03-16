package com.dabis.trimsalon.dao;

import java.util.List;

import com.dabis.trimsalon.dao.base.IGenericDao;
import com.dabis.trimsalon.beans.Factuur;

public interface IFactuurDao extends IGenericDao<Factuur, Long>
{
    List<Factuur> findAll();
}
