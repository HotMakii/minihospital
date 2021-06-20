package com.viktorijakey.minihospital.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table
@Entity(name = "DoctorTable")
@Getter @Setter @NoArgsConstructor @ToString
public class Doctor {

    public Doctor(String name2, String surname2, String speciality2, String phone2) {
        this.name=name2;
        this.surname=surname2;
        this.speciality=speciality2;
        this.phone=phone2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(value = AccessLevel.NONE) // ja nevelas Id setteri
    @Column(name = "DocId")
    private long id;

   
    @NotEmpty(message = "Lauks nedrīkst būt tukšs") // uz String - nevar būt tukšs
    @Size(min = 2, max = 60, message = "Simbolu skaitam jābūt no 4 līdz 60") // simbolu min un max skaits Stringā
    private String name;

    
    @NotEmpty(message = "Lauks nedrīkst būt tukšs") // uz String - nevar būt tukšs
    @Size(min = 2, max = 60, message = "Simbolu skaitam jābūt no 4 līdz 60") // simbolu min un max skaits Stringā
    private String surname;

    
    @NotEmpty(message = "Lauks nedrīkst būt tukšs") // uz String - nevar būt tukšs
    private String speciality;

    
    @NotEmpty(message = "Lauks nedrīkst būt tukšs")
    @Column(name = "PhoneNumber")
    private String phone;

    

    
}
