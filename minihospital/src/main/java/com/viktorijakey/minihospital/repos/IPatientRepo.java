package com.viktorijakey.minihospital.repos;

import com.viktorijakey.minihospital.models.Patient;

import org.springframework.data.repository.CrudRepository;

public interface IPatientRepo extends CrudRepository<Patient, Long>  {

    Patient findByNameAndSurnameAndPerscodeAndPhone(String name, String surname, String perscode, String phone);
    
}
