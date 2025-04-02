package com.patrickmaia.demo.repository;

import com.patrickmaia.demo.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MedicinesRepository extends JpaRepository<Medicine, Integer> {
    Medicine findByName(String name);

}
