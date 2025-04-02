package com.patrickmaia.demo.mappers;

import com.patrickmaia.demo.dtos.PrescriptionDto;
import com.patrickmaia.demo.entity.Medicine;
import com.patrickmaia.demo.entity.Prescription;
import com.patrickmaia.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PrescriptionMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private  MedicineMapper medicineMapper;

    public PrescriptionDto toDto(Prescription prescription){
        return new PrescriptionDto(
                prescription.getId(),
                userMapper.toDto(prescription.getPatient()),
                userMapper.toDto(prescription.getDoctor()),
                medicineMapper.toDto(prescription.getMedicine()),
                prescription.getDosage(),
                prescription.getTitle(),
                prescription.getDescription(),
                prescription.getPrescriptionDate());
    }

    public Prescription toEntity(PrescriptionDto prescriptionDto){

        return new Prescription(
                prescriptionDto.id(),
                userMapper.toEntity(prescriptionDto.patientId()),
                userMapper.toEntity(prescriptionDto.doctorId()),
                medicineMapper.toEntity(prescriptionDto.medicineId()),
                prescriptionDto.dosage(),
                prescriptionDto.title(),
                prescriptionDto.description(),
                prescriptionDto.prescriptionDate()

        );


    }
}
