package com.patrickmaia.demo.service;


import com.patrickmaia.demo.entity.Medicine;
import com.patrickmaia.demo.repository.MedicinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class MedicineService {
    @Autowired
    private MedicinesRepository medicinesRepository;

    public List<Medicine>getAllMedicine(){
        return medicinesRepository.findAll();

    }

    public Medicine getById(int id){
        return medicinesRepository.findById(id).orElse(null);
    }

    public Medicine createMedicine(Medicine medicine){
        return medicinesRepository.save(medicine);
    }

    public Medicine updateMedicine(int id, Medicine medicineDetails){
        return medicinesRepository.findById(id)
                .map(medicine ->{
                    medicine.setName(medicine.getName());
                    medicine.setStock(medicine.getStock());
                    return medicinesRepository.save(medicine);
                }).orElse(null);
    }


    public void deleteMedicine(int id){
        medicinesRepository.deleteById(id);
    }
}

