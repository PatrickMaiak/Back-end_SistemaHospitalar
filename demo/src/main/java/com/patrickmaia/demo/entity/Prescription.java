package com.patrickmaia.demo.entity;

//import com.patrickmaia.demo.dtos.MedicineDto;
//import com.patrickmaia.demo.dtos.UserDto;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private User doctor;

    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "id")
    private Medicine medicine;

    private String dosage;
    private String title;
    private String description;
    private java.sql.Date prescriptionDate;

    public Prescription() {
    }

    public Prescription(int id, User patient, User doctor, Medicine medicine, String dosage, String title, String description, Date prescriptionDate) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.medicine = medicine;
        this.dosage = dosage;
        this.title = title;
        this.description = description;
        this.prescriptionDate = prescriptionDate;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }
}
