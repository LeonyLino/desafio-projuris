package br.com.desfio.projuris.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Erro {

	private int statusCode;
	private String message;

}