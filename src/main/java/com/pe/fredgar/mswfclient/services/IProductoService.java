package com.pe.fredgar.mswfclient.services;

import com.pe.fredgar.mswfclient.api.models.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductoService {

    public Flux<Producto> listarProductos();
    public Mono<Producto> buscarPorId(String id);
    public Mono<Producto> guardar(Producto producto);
    public Mono<Producto> actualizar(Producto producto, String id);
    public Mono<Void> eliminarPorId(String id);

}
