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
    private UsersRepository userRepository;

    @Autowired
    private MedicinesRepository medicineRepository;

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

            prescription.setPatient(userRepository.findById(prescription.getPatient().getId()).orElse(null));
            prescription.setDoctor(userRepository.findById(prescription.getDoctor().getId()).orElse(null));
            prescription.setMedicine(medicineRepository.findById(prescription.getMedicine().getId()).orElse(null));

            return prescriptionRepository.save(prescription);


    }

    public void deletePrescription(int id){
        prescriptionRepository.deleteById(id);
    }
}
