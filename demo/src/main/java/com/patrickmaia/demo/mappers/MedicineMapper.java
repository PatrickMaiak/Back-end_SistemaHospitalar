package com.patrickmaia.demo.mappers;

import com.patrickmaia.demo.dtos.MedicineDto;
import com.patrickmaia.demo.entity.Medicine;
import org.springframework.stereotype.Service;

@Service
public class MedicineMapper {

    public  MedicineDto toDto(Medicine medicine){
        return new MedicineDto(medicine.getId(),medicine.getName(), medicine.getStock());
    }

    public  Medicine toEntity(MedicineDto medicineDto){
        return new Medicine(medicineDto.id(),medicineDto.name(),medicineDto.stock());
    }
}
