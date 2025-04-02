package com.patrickmaia.demo.controller;


import com.patrickmaia.demo.dtos.PrescriptionDto;
import com.patrickmaia.demo.dtos.UserDto;
import com.patrickmaia.demo.entity.Prescription;
import com.patrickmaia.demo.entity.User;
import com.patrickmaia.demo.mappers.PrescriptionMapper;
import com.patrickmaia.demo.mappers.UserMapper;
import com.patrickmaia.demo.service.PrescriptionService;
import com.patrickmaia.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private UserService userService;
    @Autowired
    private PrescriptionMapper prescriptionMapper;


    @GetMapping
    public List<PrescriptionDto> getAll(){

        return prescriptionService.getAll().stream().map(prescriptionMapper::toDto).toList();
    }
    @GetMapping("/get/{id}")
    public PrescriptionDto getOne(@PathVariable Integer id){

        return prescriptionMapper.toDto(prescriptionService.getById(id));
    }
    @PostMapping
    public PrescriptionDto createPrescription(@RequestBody PrescriptionDto prescriptionDto ){

        Prescription prescription = prescriptionMapper.toEntity(prescriptionDto);
        Prescription savedPrescription = prescriptionService.createPrescription(prescription);

        return prescriptionMapper.toDto(savedPrescription);

    }


    @DeleteMapping
    public void deletePrescription(@PathVariable int id){
        prescriptionService.deletePrescription(id);
    }
}
