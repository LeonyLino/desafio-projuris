package br.com.desfio.projuris.services.ordemservico;

import java.util.List;

import br.com.desfio.projuris.model.dto.OrdemDeServicoDTOIn;
import br.com.desfio.projuris.model.dto.OrdemDeServicoDTOOut;

public interface OrdemDeServicoService {

	OrdemDeServicoDTOOut cadastrar(OrdemDeServicoDTOIn dto);

	List<OrdemDeServicoDTOOut> buscarPorFiltros(OrdemDeServicoDTOIn dto);

	List<OrdemDeServicoDTOOut> listar();

	OrdemDeServicoDTOOut iniciarEFinalizarServico(OrdemDeServicoDTOIn dto);

	void cadastrarNovaObservacao(OrdemDeServicoDTOIn dto);

}
