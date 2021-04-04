package com.doctor.appointment.controller;

import com.doctor.appointment.dto.CompanyDto;
import com.doctor.appointment.dto.CreateEmployeeDto;
import com.doctor.appointment.dto.DoctorDto;
import com.doctor.appointment.dto.EmployeeDto;
import com.doctor.appointment.repository.EmployeeRepository;
import com.doctor.appointment.service.CompanyService;
import com.doctor.appointment.service.DoctorService;
import com.doctor.appointment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/createCompany")
    public String createCompany(@RequestBody CompanyDto companyDto){
        return companyService.createCompany(companyDto);
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<Object> createEmployee(@RequestBody CreateEmployeeDto createEmployeeDto){
        return employeeService.createEmployeeAndAsignToCompany(createEmployeeDto);
    }

    @GetMapping("/getCompanyByName")
    public ResponseEntity<Object> getCompanybyName(@RequestParam String companyName) throws Exception{
        return companyService.getCompanyByName(companyName);
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getAll")
    public List<DoctorDto> getAllDoctors(){
        return doctorService.getAll();
    }

    @PostMapping("/addDoctor")
    public String addDoctor(@RequestBody DoctorDto doctorDto){
        return doctorService.addDoctor(doctorDto);
    }

    @GetMapping("/test")
    public String getTest(){
        return "Ok";
    }

    @GetMapping("/add")
    public String addMethod(@RequestParam String value){
        return value;
    }

    @GetMapping("/doctor/{id}")
    public String getDoctor(@PathVariable String id){
        return id ;
    }

    @PostMapping("/catalog")
    public String addToCatalog(@RequestBody DoctorDto DoctorDto){
        System.out.println(DoctorDto.getName());
        System.out.println(DoctorDto.getAge());

        return "Ok";
    }
}