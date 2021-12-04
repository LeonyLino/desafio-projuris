package br.com.desfio.projuris.services.ordemservico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.desfio.projuris.exceptions.OrdemDeServicoNaoEncontradoException;
import br.com.desfio.projuris.model.Cliente;
import br.com.desfio.projuris.model.HistoricoAcompanhamento;
import br.com.desfio.projuris.model.OrdemDeServico;
import br.com.desfio.projuris.model.Responsavel;
import br.com.desfio.projuris.model.dto.OrdemDeServicoDTOIn;
import br.com.desfio.projuris.model.dto.OrdemDeServicoDTOOut;
import br.com.desfio.projuris.model.dto.converter.OrdemDeServicoDTOConverter;
import br.com.desfio.projuris.repository.OrdemDeServicoRepository;
import br.com.desfio.projuris.services.cliente.ClienteService;
import br.com.desfio.projuris.services.equipamento.EquipamentoService;
import br.com.desfio.projuris.services.histcompanhamento.HistoricoAcompanhamentoService;
import br.com.desfio.projuris.services.responsavel.ResponsavelService;
import br.com.desfio.projuris.specification.OrdemDeServicoSpecification;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdemDeServicoServiceImpl implements OrdemDeServicoService {

	private final OrdemDeServicoRepository odsRepository;
	private final OrdemDeServicoDTOConverter odsDTOConverter;
	private final ClienteService cService;
	private final EquipamentoService eService;
	private final ResponsavelService rService;
	private final HistoricoAcompanhamentoService haService;

	@Transactional
	private OrdemDeServico salvar(OrdemDeServicoDTOIn dto, Cliente cliente, Responsavel responsavel) {
		return odsRepository.save(new OrdemDeServico(cliente, responsavel));
	}

	@Override
	@Transactional
	public OrdemDeServicoDTOOut cadastrar(OrdemDeServicoDTOIn dto) {
		Cliente cliente = cService.salvar(dto.getClienteDTO());
		Responsavel responsavel = null;

		if (!StringUtils.isBlank(dto.getMatriculaResponsavel())) {
			responsavel = rService.buscarPorMatricula(dto.getMatriculaResponsavel());
		}

		OrdemDeServico ordem = this.salvar(dto, cliente, responsavel);
		if(responsavel != null) {
			ordem.setDataInicioServico(LocalDateTime.now());
		}
		
		haService.salvar(new HistoricoAcompanhamento(null, dto.getDescObservacao(), LocalDateTime.now(), ordem));
		ordem.setEquipamentos(eService.salvar(dto.getEquipamentosDTO(), ordem));

		return odsDTOConverter.convert(ordem);
	}

	@Override
	public List<OrdemDeServicoDTOOut> buscarPorFiltros(OrdemDeServicoDTOIn dto) {

		Specification<OrdemDeServico> querySpecification = Specification
				.where(OrdemDeServicoSpecification.matriculaResponsavel(dto.getMatriculaResponsavel())
						.or(OrdemDeServicoSpecification.nomeResponsavel(dto.getNomeResponsavel()))
						.and(OrdemDeServicoSpecification.flagConcluido(Boolean.FALSE)));

		return odsRepository.findAll(querySpecification).stream().map(odsDTOConverter::convert)
				.collect(Collectors.toList());
	}

	@Override
	public List<OrdemDeServicoDTOOut> listar() {
		return odsRepository.findAll().stream().map(odsDTOConverter::convert).collect(Collectors.toList());
	}

	private OrdemDeServico buscarPorId(Long id) {
		return odsRepository.findById(id).orElseThrow(OrdemDeServicoNaoEncontradoException::new);
	}

	@Override
	@Transactional
	public OrdemDeServicoDTOOut iniciarEFinalizarServico(OrdemDeServicoDTOIn dto) {
		OrdemDeServico ordem = buscarPorId(dto.getId());

		switch (dto.getStatus()) {
		case INICIAR:
			ordem.setResponsavel(rService.buscarPorMatricula(dto.getMatriculaResponsavel()));
			ordem.setDataInicioServico(LocalDateTime.now());
			break;
		case FINALIZAR:
			ordem.setDataFimServico(LocalDateTime.now());
			ordem.setFlConcluido(Boolean.TRUE);
			break;
		default:
			break;
		}

		return odsDTOConverter.convert(odsRepository.save(ordem));
	}

	@Override
	public void cadastrarNovaObservacao(OrdemDeServicoDTOIn dto) {
		haService.salvar(new HistoricoAcompanhamento(null, dto.getDescObservacao(), LocalDateTime.now(),
				buscarPorId(dto.getId())));
	}

}
