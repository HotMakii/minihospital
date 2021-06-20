package com.viktorijakey.minihospital.repos;

import com.viktorijakey.minihospital.models.Doctor;

import org.springframework.data.repository.CrudRepository;

public interface IDoctorRepo extends CrudRepository<Doctor, Long>  {

    Doctor findByNameAndSurnameAndSpecialityAndPhone(String name, String surname, String speciality, String phone);

    Doctor findById(long id);
    
}
