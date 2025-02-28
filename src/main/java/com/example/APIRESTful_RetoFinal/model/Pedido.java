package com.example.APIRESTful_RetoFinal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    private String id;
    private String producto;
    private int cantidad;
    private double precioTotal;
}