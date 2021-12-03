package br.com.desfio.projuris.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EquipamentoDTO {

	private Long id;
	@NotNull
	@Size(min = 3, max = 50)
	private String tipo;
	@NotNull
	@Size(min = 3, max = 50)
	private String marca;
	@NotNull
	@Size(min = 3, max = 255)
	private String descProblema;

}
