package com.viktorijakey.minihospital.repos;

import com.viktorijakey.minihospital.models.Appointment;

import org.springframework.data.repository.CrudRepository;

public interface IAppointmentRepo extends CrudRepository<Appointment, Long>{
     
}
