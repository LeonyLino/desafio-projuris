package br.com.desfio.projuris.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusOrdemServicoEnum {
	INICIAR("iniciar"), FINALIZAR("finalizar");
	
	private String descricao;
}
