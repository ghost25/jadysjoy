package com.dabis.trimsalon.dao;

import java.util.List;

import com.dabis.trimsalon.dao.base.IGenericDao;
import com.dabis.trimsalon.beans.Klant;

public interface IKlantDao extends IGenericDao<Klant, Long>
{
    List<Klant> findAll();
}
