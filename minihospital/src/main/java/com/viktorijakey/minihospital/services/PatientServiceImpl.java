package com.viktorijakey.minihospital.services;

import java.util.ArrayList;

import com.viktorijakey.minihospital.models.Patient;
import com.viktorijakey.minihospital.repos.IPatientRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    IPatientRepo patientRepo;

    @Override
    public ArrayList<Patient> selectAll() {
        
        return (ArrayList<Patient>) patientRepo.findAll();
    }

    @Override
    public Patient selectById(long id) throws Exception {
        
        if(patientRepo.existsById(id))
            return patientRepo.findById(id).get(); //jalieto get, citadi izvilks optional

        throw new Exception("Id nav pareizs");
    }

    
    @Override
    public Patient addNew(String name, String surname, String perscode, String phone) throws Exception{
        //filtra funkcija
        Patient pat = patientRepo.findByNameAndSurnameAndPerscodeAndPhone(name, surname, perscode, phone);
        //ja eksiste izmet kljudu?
        if(pat!=null)
        {
            throw new Exception("Shads pacients jau ir sitema");
        }
        else{
            Patient patNew = new Patient(name, surname, perscode, phone);
            patientRepo.save(patNew);
            return patientRepo.findByNameAndSurnameAndPerscodeAndPhone(name, surname, perscode, phone);
        }
    }

    @Override
    public Patient editById(long id, Patient patient) throws Exception {
        if(patientRepo.existsById(id))
        {
            Patient pat = patientRepo.findById(id).get();
            pat.setName(patient.getName());
            pat.setSurname(patient.getSurname());
            pat.setPerscode(patient.getPerscode());
            pat.setPhone(patient.getPhone());
            patientRepo.save(pat);
            return pat;
        }else{
            throw new Exception("Id nav pareizs");
        }
    }

    @Override
    public boolean removeById(long id) {
        Patient pat = patientRepo.findById(id).get();
        if(patientRepo!=null)
        {
            patientRepo.deleteById(id);
            return true;
        }

        return false;
    }

    
    
}
