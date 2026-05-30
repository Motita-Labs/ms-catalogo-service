package com.example.catalogo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductoResponseDTO {


    private Long id;
    private String nombre;
    private Integer stock;
    private String descripcion;
    private Double precio;
}
