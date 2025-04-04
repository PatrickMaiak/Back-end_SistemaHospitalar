package com.patrickmaia.demo.service;

import com.patrickmaia.demo.entity.Prescription;
import com.patrickmaia.demo.repository.PrescriptionRepository;
import com.patrickmaia.demo.repository.UsersRepository;
import com.patrickmaia.demo.repository.MedicinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private MedicineService medicineService;

    public List<Prescription> getAll(){
        return prescriptionRepository.findAll();
    }
    public Prescription getById(Integer id){
        Optional<Prescription> prescription = prescriptionRepository.findById(id);
        if (prescription.isEmpty()) {
            throw new IllegalArgumentException("prescription not found!!");
        }
        return prescription.get();
    }
    public Prescription createPrescription(Prescription prescription){

            prescription.setPatient(userService.getById(prescription.getPatient().getId()));
            prescription.setDoctor(userService.getById(prescription.getDoctor().getId()));
            prescription.setMedicine(medicineService.getById(prescription.getMedicine().getId()));

            return prescriptionRepository.save(prescription);


    }

    public void deletePrescription(int id){
        prescriptionRepository.deleteById(id);
    }
}
