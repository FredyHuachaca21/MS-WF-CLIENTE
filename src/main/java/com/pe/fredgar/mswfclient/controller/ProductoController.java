package com.pe.fredgar.mswfclient.controller;

import com.pe.fredgar.mswfclient.api.models.Producto;
import com.pe.fredgar.mswfclient.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.LocalDate;

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

    public Mono<ServerResponse> crearProducto(ServerRequest request){
        Mono<Producto> productoMono = request.bodyToMono(Producto.class);
        return productoMono
                .flatMap(prod -> {
                    if (prod.getFechaCreacion() == null) {
                        prod.setFechaCreacion(LocalDate.now());
                    }
                return service.guardar(prod);
                })
                .flatMap( producto -> ServerResponse.created(URI.create("/api/client/".concat(producto.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(producto));
    }

    public Mono<ServerResponse> actualizarProducto(ServerRequest request) {
        Mono<Producto> productoMono = request.bodyToMono(Producto.class);
        String id = request.pathVariable("id");
        return productoMono.flatMap(prod -> ServerResponse.created(URI.create("/api/client/".concat(id)))
                   .contentType(MediaType.APPLICATION_JSON)
                   .body(service.actualizar(prod, id), Producto.class));

    }

    public Mono<ServerResponse> eliminarProducto(ServerRequest request) {
        String id = request.pathVariable("id");
        return  service.eliminarPorId(id)
                .then(ServerResponse.noContent().build());

    }
}
