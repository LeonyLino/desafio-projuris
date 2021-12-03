package br.com.desfio.projuris.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponsavelDTO {

	private Long id;
	private String nome;
	private String matricula;
	
}
