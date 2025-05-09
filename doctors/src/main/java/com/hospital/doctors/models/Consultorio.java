package com.hospital.doctors.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Consultorios")
@AllArgsConstructor
public class Consultorio {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false)
    private int numero;
    @Column(nullable=false)
    private int piso;

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
