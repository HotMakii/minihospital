package com.viktorijakey.minihospital.services;

import java.util.ArrayList;

import com.viktorijakey.minihospital.models.Patient;

public interface IPatientService {

    //select all
    public abstract ArrayList<Patient> selectAll();
    //add new
    public abstract Patient addNew(String name, String surname, String perscode, String phone) throws Exception;
    //edit by id
    public abstract Patient editById(long id, Patient patient) throws Exception;
    //remove by id
    public abstract boolean removeById(long id);

    public abstract Patient selectById(long id)throws Exception;
    
}
