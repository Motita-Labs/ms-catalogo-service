package com.example.catalogo.service;

import com.example.catalogo.dto.ProductoRequestDTO;
import com.example.catalogo.dto.ProductoResponseDTO;
import com.example.catalogo.model.Producto;
import com.example.catalogo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    private Producto getProductOrTrow(Long id){
        return productoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus
                        .NOT_FOUND,("Producto no encontrado")));
    }

    public ProductoResponseDTO createProduct (ProductoRequestDTO request){
        Producto varProducto = Producto.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .stock(request.getStock())
                .precio(request.getPrecio())
                .build();

        Producto dbResponse = productoRepository.save(varProducto);

        return ProductoResponseDTO.builder()
                .id(dbResponse.getId())
                .nombre(dbResponse.getNombre())
                .descripcion(dbResponse.getDescripcion())
                .stock(dbResponse.getStock())
                .precio(dbResponse.getPrecio())
                .build();
    }
    public List <ProductoResponseDTO> getAllProducts (){
        List <Producto> productList = productoRepository.findAll();
        List <ProductoResponseDTO> responseList = new ArrayList <>();
        for (Producto product : productList){
            ProductoResponseDTO response = ProductoResponseDTO.builder()
                    .id(product.getId())
                    .nombre(product.getNombre())
                    .descripcion(product.getDescripcion())
                    .stock(product.getStock())
                    .precio(product.getPrecio())
                    .build();
            responseList.add(response);
        }
        return responseList;
    }
    public ProductoResponseDTO getForId(Long id){
        Producto varProducto = getProductOrTrow(id);

        return ProductoResponseDTO.builder()
                .id(varProducto.getId())
                .nombre(varProducto.getNombre())
                .descripcion(varProducto.getDescripcion())
                .stock(varProducto.getStock())
                .precio(varProducto.getPrecio())
                .build();
    }
    public ProductoResponseDTO editProduct(ProductoRequestDTO request, Long id){
        Producto varProducto = getProductOrTrow(id);
        varProducto.setNombre(request.getNombre());
        varProducto.setDescripcion(request.getDescripcion());
        varProducto.setStock(request.getStock());
        varProducto.setPrecio(request.getPrecio());
        productoRepository.save(varProducto);
        return  ProductoResponseDTO.builder()
                .id(varProducto.getId())
                .nombre(varProducto.getNombre())
                .descripcion(varProducto.getDescripcion())
                .stock(varProducto.getStock())
                .precio(varProducto.getPrecio())
                .build();
    }
    public void deleteProduct( Long id){
        getProductOrTrow(id);
        productoRepository.deleteById(id);
    }



}
