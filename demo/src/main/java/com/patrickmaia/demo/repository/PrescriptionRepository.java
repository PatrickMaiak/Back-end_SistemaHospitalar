package com.patrickmaia.demo.repository;

import com.patrickmaia.demo.entity.Prescription;
import com.patrickmaia.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Integer> {



}
