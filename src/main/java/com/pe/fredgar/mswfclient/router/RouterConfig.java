package com.pe.fredgar.mswfclient.router;

import com.pe.fredgar.mswfclient.controller.ProductoController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> rutas(ProductoController controller){
        return route(GET("/api/client"), controller::listar)
                .andRoute(GET("/api/client/{id}"), controller::listarPorID)
                .andRoute(POST("/api/client"), controller::crearProducto)
                .andRoute(PUT("/api/client/{id}"), controller::actualizarProducto)
                .andRoute(DELETE("/api/client/{id}"), controller::eliminarProducto);
    }

}
