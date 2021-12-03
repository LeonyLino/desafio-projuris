package br.com.desfio.projuris.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrdemDeServicoDTOOut {

	private Long id;
	private LocalDateTime dataInicioServico;
	private LocalDateTime dataFimServico;
	private ClienteDTO clienteDTO;
	private ResponsavelDTO responsavel;
	private List<EquipamentoDTO> equipamentos;
	private List<HistoricoAcompanhamentoDTO> histAcompanhamentosDTO;
}
