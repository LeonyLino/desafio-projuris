package br.com.desfio.projuris.model.dto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.desfio.projuris.model.HistoricoAcompanhamento;
import br.com.desfio.projuris.model.dto.HistoricoAcompanhamentoDTO;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HistoricoAcompanhamentoDTOConverter
		implements Converter<HistoricoAcompanhamento, HistoricoAcompanhamentoDTO> {

	@Override
	public HistoricoAcompanhamentoDTO convert(HistoricoAcompanhamento historicoAcompanhamento) {
		return HistoricoAcompanhamentoDTO.builder().id(historicoAcompanhamento.getId())
				.data(historicoAcompanhamento.getData()).descObservacao(historicoAcompanhamento.getDescObservacao())
				.build();
	}

}
