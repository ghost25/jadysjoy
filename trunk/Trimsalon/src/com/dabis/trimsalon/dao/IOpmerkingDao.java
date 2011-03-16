package com.dabis.trimsalon.dao;

import java.util.List;

import com.dabis.trimsalon.dao.base.IGenericDao;
import com.dabis.trimsalon.beans.Opmerking;

public interface IOpmerkingDao extends IGenericDao<Opmerking, Long>
{
    List<Opmerking> findAll();
}
