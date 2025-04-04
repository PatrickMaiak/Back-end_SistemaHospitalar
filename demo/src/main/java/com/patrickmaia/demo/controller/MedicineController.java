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
        System.out.println("aqui esta o teste de saida do getAll ");
        return medicineService.getAllMedicine().stream().map(medicineMapper::toDto).toList();
    }

    @GetMapping("/id/{id}")
    public MedicineDto getById(@PathVariable Integer id){
        System.out.println("aqui esta o teste de saida do getById ");
        return medicineMapper.toDto(medicineService.getById(id));
        
    }
    @PostMapping
    public MedicineDto createMedicine(@RequestBody MedicineDto medicineDto){
        Medicine medicineDetails = medicineMapper.toEntity(medicineDto);
        Medicine medicineSaved = medicineService.createMedicine(medicineDetails);
        return medicineMapper.toDto(medicineSaved);
    }

    @PostMapping("/{id}")
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
