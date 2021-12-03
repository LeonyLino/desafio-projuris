package br.com.desfio.projuris.model.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HistoricoAcompanhamentoDTO {

	private Long id;
	private String descObservacao;
	private LocalDateTime data;
}
