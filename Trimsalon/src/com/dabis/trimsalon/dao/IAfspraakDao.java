package com.dabis.trimsalon.dao;

import java.util.List;

import com.dabis.trimsalon.dao.base.IGenericDao;
import com.dabis.trimsalon.beans.Afspraak;

public interface IAfspraakDao extends IGenericDao<Afspraak, Long>
{
    List<Afspraak> findAll();
}
