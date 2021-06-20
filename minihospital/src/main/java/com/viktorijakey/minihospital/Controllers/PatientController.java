package com.viktorijakey.minihospital.Controllers;

import javax.validation.Valid;

import com.viktorijakey.minihospital.models.Patient;
import com.viktorijakey.minihospital.services.IPatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatientController {

    @Autowired
    IPatientService patientService;

    @GetMapping("/patient/allPatients")
    public String showPatientList(Model model) {

    model.addAttribute("patients", patientService.selectAll());

    return "patient-list-page";
  }

  @GetMapping("/patient/addPatient")
  public String addNewPatient(Model model) {

    model.addAttribute("patient", new Patient());

    return "add-new-patient-page";
  }

  @PostMapping("/patient/addPatient")
  public String postAddNewPatient(@Valid Patient patient, BindingResult result) throws Exception// dabujam aizplditu pacientu bet bez id
  {
      System.out.println(patient);
      System.out.println(result);
      if (!result.hasErrors()) //vai nav validacijas parkapums
      {
          patientService.addNew(patient.getName(), patient.getSurname(), patient.getPerscode(), patient.getPhone());

          return "redirect:/patient/allPatients"; 
      }
      else
          return "add-new-patient-page";
  }

  
  @GetMapping("/patient/editPatient/{id}") 
  public String getEditPatient(@PathVariable("id") long id, Model model) {
      try {
          model.addAttribute("patient", patientService.selectById(id));
          return "patient-edit-page";

      } catch (Exception e) {
          return "patient-error"; 

      }
  }

  @PostMapping("/patient/editPatient/{id}")
  public String postEditPatient(@PathVariable("id") long id, @Valid Patient patient, BindingResult result) {
      if (!result.hasErrors()) // vai nav validacijas parkapums
      {
          try {
              patientService.editById(id, patient);
              
              return "redirect:/patient/allPatients";
          }

          catch (Exception e) {
              return "patient-error";
          }
      } else {
          return "patient-edit-page";

      }

  }

  @GetMapping("/patient/deletePatient") 
  public String getDeletePatient(Model model, Patient patient) {
      model.addAttribute("patient", patientService.selectAll());

      return "patient-delete-page";

  }

  @PostMapping("/patient/deletePatient")
  public String postDeletePatient(Patient patient) {
      if(patientService.removeById(patient.getId()))
          return "redirect:/patient/allPatients";
      else
          return "patient-error";
  }
    
}
