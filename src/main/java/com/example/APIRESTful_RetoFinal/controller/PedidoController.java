package com.example.APIRESTful_RetoFinal.controller;

import com.example.APIRESTful_RetoFinal.model.Pedido;
import com.example.APIRESTful_RetoFinal.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    /**
     * 📌 Obtener todos los pedidos (GET /api/pedidos)
     */
    @GetMapping
    public Flux<Pedido> listarPedidos() {
        return pedidoService.obtenerPedidos();
    }

    /**
     * 📌 Crear un nuevo pedido (POST /api/pedidos)
     */
    @PostMapping
    public Mono<ResponseEntity<Pedido>> crearPedido(@RequestBody Mono<Pedido> pedidoMono) {
        return pedidoMono
            .flatMap(pedido -> {
                if (pedido == null || pedido.getProducto() == null || pedido.getCantidad() <= 0) {
                    return Mono.just(ResponseEntity.badRequest().<Pedido>build());
                }
                return pedidoService.crearPedido(pedido)
                    .map(p -> ResponseEntity.status(HttpStatus.CREATED).body(p));
                })
        .switchIfEmpty(Mono.just(ResponseEntity.badRequest().<Pedido>build())); // Manejo de request body vacío
    }
}