package com.dabis.trimsalon.dao;

import java.util.List;

import com.dabis.trimsalon.dao.base.IGenericDao;
import com.dabis.trimsalon.beans.Hond;

public interface IHondDao extends IGenericDao<Hond, Long>
{
    List<Hond> findAll();
}
