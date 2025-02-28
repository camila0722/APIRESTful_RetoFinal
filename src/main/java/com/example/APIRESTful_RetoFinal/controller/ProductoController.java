package com.example.APIRESTful_RetoFinal.controller;

import com.example.APIRESTful_RetoFinal.model.Producto;
import com.example.APIRESTful_RetoFinal.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public Flux<Producto> listarProductos() {
        return productoService.obtenerProductos();
    }
}