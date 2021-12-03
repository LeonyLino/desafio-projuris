package br.com.desfio.projuris.model.dto;

import java.util.List;

import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.desfio.projuris.enums.StatusOrdemServicoEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrdemDeServicoDTOIn {

	private Long id;
	@Size(min = 3, max = 255)
	private String descObservacao;
	@NotNull
	@Valid
	private ClienteDTO clienteDTO;
	@Size(min = 6, max = 6)
	private String matriculaResponsavel;
	@Size(min = 3, max = 100)
	private String nomeResponsavel;
	@NotNull
	@Valid
	private List<EquipamentoDTO> equipamentosDTO;
	@Enumerated
	private StatusOrdemServicoEnum status;

}
