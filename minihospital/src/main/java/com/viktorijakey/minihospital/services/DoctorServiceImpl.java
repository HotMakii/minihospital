package com.viktorijakey.minihospital.services;

import java.util.ArrayList;

import com.viktorijakey.minihospital.models.Doctor;
import com.viktorijakey.minihospital.repos.IDoctorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements IDoctorService{

    @Autowired
    IDoctorRepo doctorRepo;

    @Override
    public ArrayList<Doctor> selectAll() {
        
        return (ArrayList<Doctor>) doctorRepo.findAll();
    }

    @Override
    public Doctor selectById(long id) throws Exception {
        
        if(doctorRepo.existsById(id)){
            
            return doctorRepo.findById(id);  //jalieto get, citadi izvilks optional
        }

        throw new Exception("Id nav pareizs");

    }

    @Override
    public Doctor addNew(String name, String surname, String speciality, String phone) throws Exception{
        //filtra funkcija
        Doctor doc = doctorRepo.findByNameAndSurnameAndSpecialityAndPhone(name, surname, speciality, phone);
        //ja eksiste izmet kljudu?
        if(doc!=null)
        {
            throw new Exception("Shads dakteris jau ir sitema");
        }
        else{
            Doctor docNew = new Doctor(name, surname, speciality, phone);
            doctorRepo.save(docNew);
            return doctorRepo.findByNameAndSurnameAndSpecialityAndPhone(name, surname, speciality, phone);
        }
    }

    @Override
    public Doctor editById(long id, Doctor doctor) throws Exception {
        if(doctorRepo.existsById(id))
        {
            Doctor doc = doctorRepo.findById(id);
            doc.setName(doctor.getName());
            doc.setSurname(doctor.getSurname());
            doc.setSpeciality(doctor.getSpeciality());
            doc.setPhone(doctor.getPhone());
            doctorRepo.save(doc);
            return doc;
        }else{
            throw new Exception("Id nav pareizs");
        }
    }

    @Override
    public boolean removeById(long id) {
        Doctor doc = doctorRepo.findById(id);
        if(doc!=null)
        {
            doctorRepo.deleteById(id);
            return true;
        }

        return false;
    }

    


    

}
