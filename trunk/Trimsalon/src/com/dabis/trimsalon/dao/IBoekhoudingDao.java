package com.dabis.trimsalon.dao;

import java.util.List;

import com.dabis.trimsalon.dao.base.IGenericDao;
import com.dabis.trimsalon.beans.Boekhouding;

public interface IBoekhoudingDao extends IGenericDao<Boekhouding, Long>
{
    List<Boekhouding> findAll();
}
