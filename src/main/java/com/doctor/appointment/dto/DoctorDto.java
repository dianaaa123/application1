package com.doctor.appointment.dto;

import com.doctor.appointment.model.Doctor;

public class DoctorDto {
    private String name;
    private String age;

    public DoctorDto() {
    }

    public DoctorDto(Doctor doctor){
        this.name = doctor.getName();
        this.age = doctor.getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}