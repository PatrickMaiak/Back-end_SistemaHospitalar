package com.patrickmaia.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "stock")
    private int stock;
    
    
    public Medicine(){}

    public Medicine(int id, String name, int stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
