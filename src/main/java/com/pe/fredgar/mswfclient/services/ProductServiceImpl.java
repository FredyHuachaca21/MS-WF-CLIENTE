package com.pe.fredgar.mswfclient.services;

import com.pe.fredgar.mswfclient.api.AppConfig;
import com.pe.fredgar.mswfclient.api.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
@Service
public class ProductServiceImpl implements IProductoService{

    @Autowired
    WebClient client;

    @Override
    public Flux<Producto> listarProductos() {
        return client.get().accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Producto.class);
    }

    @Override
    public Mono<Producto> buscarPorId(String id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return client.get().uri("/{id}", params)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Producto.class);
    }

    @Override
    public Mono<Producto> guardar(Producto producto) {
        return null;
    }

    @Override
    public Mono<Producto> actualizar(Producto producto, String id) {
        return null;
    }

    @Override
    public Mono<Void> eliminarPorId(String id) {
        return null;
    }
}
