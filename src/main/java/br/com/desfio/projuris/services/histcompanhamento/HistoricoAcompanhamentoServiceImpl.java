package br.com.desfio.projuris.services.histcompanhamento;

import org.springframework.stereotype.Service;

import br.com.desfio.projuris.model.HistoricoAcompanhamento;
import br.com.desfio.projuris.repository.HistoricoAcompanhamentoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistoricoAcompanhamentoServiceImpl implements HistoricoAcompanhamentoService {

	private final HistoricoAcompanhamentoRepository haRepository;

	@Override
	public HistoricoAcompanhamento salvar(HistoricoAcompanhamento histAcompanhamento) {
		return haRepository.save(histAcompanhamento);
	}

}
