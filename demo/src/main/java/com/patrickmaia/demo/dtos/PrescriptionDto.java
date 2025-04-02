package com.patrickmaia.demo.dtos;

import com.patrickmaia.demo.entity.Medicine;
import com.patrickmaia.demo.entity.User;

import java.sql.Date;

public record PrescriptionDto(
        int id,
        UserDto patientId,
        UserDto doctorId,
        MedicineDto medicineId,
        String dosage,
        String title,
        String description,
        java.sql.Date prescriptionDate) {

}
