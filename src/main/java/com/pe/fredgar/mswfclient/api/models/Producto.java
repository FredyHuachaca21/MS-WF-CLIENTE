package com.pe.fredgar.mswfclient.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class Producto {

	private String id;
	private String nombre;
	private Double precio;
	private LocalDate fechaCreacion;
	private Categoria categoria;
	private String foto;

	
	

}
