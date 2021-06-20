package com.viktorijakey.minihospital.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table
@Entity(name = "PatientTable")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Patient {

    public Patient(String name2, String surname2, String perscode2, String phone) {
        this.name=name2;
        this.surname=surname2;
        this.perscode=perscode2;
        this.phone=phone;
    }

    // 1.variables
    @Id // @Unique: piem, lietotājvārds
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PatId")
    private long id;

    @Column(name = "Name")
    @NotNull
    @NotEmpty(message = "Lauks nedrīkst būt tukšs")
    @Size(min = 2, max = 20, message = "Simbolu skaitam jābūt no 2 līdz 20")
    @Pattern(regexp = "[A-Za-zāčēīķļņšūžĀČĒĪĶĻŅŠŪŽĢģ]+", message = "Laukam jāsatur tikai burti")
    private String name;

    @Column(name = "Surname")
    @NotNull
    @NotEmpty(message = "Lauks nedrīkst būt tukšs")
    @Size(min = 2, max = 20, message = "Simbolu skaitam jābūt no 2 līdz 20")
    @Pattern(regexp = "[A-Za-zāčēīķļņšūžĀČĒĪĶĻŅŠŪŽĢģ]+", message = "Laukam jāsatur tikai burti")
    private String surname;

    @Column(name = "PersonalCode")
    @NotNull
    @NotEmpty(message = "Lauks nedrīkst būt tukšs")
    @Size(min = 2, max = 20, message = "Simbolu skaitam jābūt no 2 līdz 20")
    private String perscode;

    @Column(name = "PhoneNumber")
    @NotEmpty(message = "Lauks nedrīkst būt tukšs")
    private String phone;


    
}
