package com.patrickmaia.demo.dtos;

public record MedicineDto(int id, String name, int stock) {
    public int getId() {
        return id;
    }
}
