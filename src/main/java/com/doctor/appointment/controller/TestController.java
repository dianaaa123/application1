package com.doctor.appointment.controller;

import com.doctor.appointment.dto.*;
import com.doctor.appointment.repository.EmployeeRepository;
import com.doctor.appointment.service.CompanyService;
import com.doctor.appointment.service.DoctorService;
import com.doctor.appointment.service.EmployeeService;
import com.doctor.appointment.service.MediaService;
import com.doctor.appointment.util.HttpStatusHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.doctor.appointment.util.HttpStatusHelper.success;

@RestController
public class TestController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MediaService mediaService;

    @Autowired
    private HttpStatusHelper httpStatusHelper;

    @PostMapping("/addPicture")
    public ResponseEntity<Object> addPictureToEmployee(@RequestParam String fileName,
                                                       @RequestParam Long employeeId,
                                                       @RequestParam String type){
        try {
            return success("ok", mediaService.addMediaToEmployee(fileName, employeeId, type));
        }catch(Exception e){
            return httpStatusHelper.commonErrorMethod(e);
        }
    }

    @PostMapping("/addHobby")
    public ResponseEntity<Object> addHobbyToEmployee(@RequestBody EmployeeHobbyDto employeeHobbyDto){
        return employeeService.addHobbyToEmployee(employeeHobbyDto);
    }

    @PostMapping("/createCompany")
    public String createCompany(@RequestBody CompanyDto companyDto){
        return companyService.createCompany(companyDto);
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<Object> createEmployee(@RequestBody CreateEmployeeDto createEmployeeDto){
        return success("employee", employeeService.createEmployeeAndAsignToCompany(createEmployeeDto));
    }

    @GetMapping("/getCompanyByName")
    public ResponseEntity<Object> getCompanybyName(@RequestParam String companyName) throws Exception{
        return companyService.getCompanyByName(companyName);
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable Long id) throws Exception {
        try{
            return success("employee"
                    ,employeeService.getEmployeeById(id));
        }
        catch(Exception e){
            return httpStatusHelper.commonErrorMethod(e);
        }
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