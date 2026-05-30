package com.example.catalogo.controller;

import com.example.catalogo.dto.ProductoRequestDTO;
import com.example.catalogo.dto.ProductoResponseDTO;
import com.example.catalogo.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping()
    public ResponseEntity<ProductoResponseDTO> createProduct(@Valid @RequestBody ProductoRequestDTO request){
        return ResponseEntity.status(CREATED)
                .body(productoService.createProduct(request));
    }
    @GetMapping()
    public ResponseEntity<List<ProductoResponseDTO>>  getAllProducts(){
        return ResponseEntity.ok(productoService.getAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> getForId(@PathVariable Long id){
        return ResponseEntity.ok(productoService.getForId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> editProduct(@Valid @RequestBody ProductoRequestDTO request,@PathVariable Long id){
        return ResponseEntity.ok(productoService.editProduct(request,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productoService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }




}
