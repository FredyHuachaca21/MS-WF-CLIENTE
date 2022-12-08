package com.pe.fredgar.mswfclient.controller;

import com.pe.fredgar.mswfclient.api.models.Producto;
import com.pe.fredgar.mswfclient.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProductoController {

    @Autowired
    private ProductServiceImpl service;

    public Mono<ServerResponse> listar(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.listarProductos(), Producto.class);
    }
    public Mono<ServerResponse> listarPorID(ServerRequest request){
        String id = request.pathVariable("id");
        return service.buscarPorId(id)
                        .flatMap( producto -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.buscarPorId(id), Producto.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
