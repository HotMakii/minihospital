package com.viktorijakey.minihospital.Controllers;

import javax.validation.Valid;

import com.viktorijakey.minihospital.models.Doctor;
import com.viktorijakey.minihospital.services.IDoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DoctorController {
    
    @Autowired
    IDoctorService doctorService;

    @GetMapping("/doctor/allDoctors")
    public String showDoctorList(Model model) {

    model.addAttribute("doctors", doctorService.selectAll());

    return "doctor-list-page";
  }

  @GetMapping("/doctor/addDoctor")
  public String addNewDoctor(Model model) {

    model.addAttribute("doctor", new Doctor());

    return "add-new-doctor-page";
  }

  @PostMapping("/doctor/addDoctor")
  public String postAddNewDoctor(@Valid Doctor doctor, BindingResult result) throws Exception// dabujam aizplditu dakteri bet bez id
  {
      System.out.println(doctor);
      System.out.println(result);
      if (!result.hasErrors()) //vai nav validacijas parkapums
      {
          doctorService.addNew(doctor.getName(), doctor.getSurname(), doctor.getSpeciality(), doctor.getPhone());

          return "redirect:/doctor/allDoctors"; 
      }
      else
          return "add-new-doctor-page";
  }

  
  @GetMapping("/doctor/editDoctor/{id}") 
  public String getEditDoctor(@PathVariable("id") long id, Model model) {
      try {
          model.addAttribute("doctor", doctorService.selectById(id));
          return "doctor-edit-page";

      } catch (Exception e) {
          return "product-error"; 

      }
  }

  @PostMapping("/doctor/editDoctor/{id}")
  public String postEditDoctor(@PathVariable("id") long id, @Valid Doctor doctor, BindingResult result) {
      if (!result.hasErrors()) // vai nav validacijas parkapums
      {
          try {
              doctorService.editById(id, doctor);
              
              return "redirect:/doctor/allDoctors";
          }

          catch (Exception e) {
              return "doctor-error";
          }
      } else {
          return "doctor-edit-page";

      }

  }

  @GetMapping("/doctor/deleteDoctor") 
  public String getDeleteDoctor(Model model, Doctor doctor) {
      model.addAttribute("doctor", doctorService.selectAll());

      return "doctor-delete-page";

  }

  @PostMapping("/doctor/deleteDoctor")
  public String postDeleteDoctor(Doctor doctor) {
      if(doctorService.removeById(doctor.getId()))
          return "redirect:/doctor/allDoctors";
      else
          return "doctor-error";
  }
}
