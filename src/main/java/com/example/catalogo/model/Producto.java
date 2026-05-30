package com.example.catalogo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="producto")
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 20)
    private String nombre;
    @Column(nullable = false)
    private Integer stock;
    @Column(nullable = false,length = 100)
    private String descripcion;
    @Column(nullable = false,length = 20)
    private Double precio;
}
