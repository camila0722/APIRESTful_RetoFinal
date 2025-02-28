package com.example.APIRESTful_RetoFinal.service;

import com.example.APIRESTful_RetoFinal.model.Pedido;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class PedidoService {
    private final List<Pedido> pedidos = new CopyOnWriteArrayList<>();

    public Flux<Pedido> obtenerPedidos() {
        return Flux.fromIterable(pedidos);
    }

    public Mono<Pedido> crearPedido(Pedido pedido) {
        pedido.setId(UUID.randomUUID().toString());
        pedidos.add(pedido);
        return Mono.just(pedido);
    }
}