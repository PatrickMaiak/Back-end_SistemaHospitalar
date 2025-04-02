package com.patrickmaia.demo.controller;

import com.patrickmaia.demo.dtos.MedicineDto;
import com.patrickmaia.demo.entity.Medicine;
import com.patrickmaia.demo.mappers.MedicineMapper;
import com.patrickmaia.demo.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;
    @Autowired
    private MedicineMapper medicineMapper;

    @GetMapping
    public List<MedicineDto> getAllMedicines(){
        return medicineService.getAllMedicine().stream().map(medicineMapper::toDto).toList();
    }

    @GetMapping("medicine/id")
    public MedicineDto getMedicine(@PathVariable("id") int id){
        return medicineMapper.toDto(medicineService.getOneMedicine(id));
        
    }
    @PostMapping
    public MedicineDto createMedicine(@RequestBody MedicineDto medicineDto){
        Medicine medicineDetails = medicineMapper.toEntity(medicineDto);
        Medicine medicineSaved = medicineService.createMedicine(medicineDetails);
        return medicineMapper.toDto(medicineSaved);
    }

    @PostMapping("medicine/id")
    public MedicineDto upadateMedicine(@PathVariable("id") int id, MedicineDto medicineDetails ){
        Medicine medicine = medicineMapper.toEntity(medicineDetails);
        Medicine medicineUpdated = medicineService.updateMedicine(id,medicine);

        return  medicineMapper.toDto(medicineUpdated);
    }

    @DeleteMapping
    public void deleteMedicine(int id){
        medicineService.deleteMedicine(id);
    }
}
