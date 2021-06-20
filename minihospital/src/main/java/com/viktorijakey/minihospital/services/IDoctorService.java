package com.viktorijakey.minihospital.services;

import java.util.ArrayList;

import com.viktorijakey.minihospital.models.Doctor;

public interface IDoctorService {

    //select all
    public abstract ArrayList<Doctor> selectAll();
    //select by id
    public abstract Doctor selectById(long id)throws Exception;
    //add new
    public abstract Doctor addNew(String name, String surname, String speciality, String phone) throws Exception;
    //edit by id
    public abstract Doctor editById(long id, Doctor doctor) throws Exception;
    //remove by id
    public abstract boolean removeById(long id);
    
}
