package com.pe.fredgar.mswfclient.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

	private String id;
	private String nombre;

	public Categoria(String nombre) {
		this.nombre = nombre;
	}
	

}
