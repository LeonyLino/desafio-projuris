package br.com.desfio.projuris.model.dto.converter;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.desfio.projuris.model.OrdemDeServico;
import br.com.desfio.projuris.model.dto.OrdemDeServicoDTOOut;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrdemDeServicoDTOConverter implements Converter<OrdemDeServico, OrdemDeServicoDTOOut> {

	private final ClienteDTOConverter cDTOConverter;
	private final ResponsavelDTOConverter rDTOConverter;
	private final EquipamentoDTOConverter eDTOConverter;
	private final HistoricoAcompanhamentoDTOConverter haDTOConverter;

	@Override
	public OrdemDeServicoDTOOut convert(OrdemDeServico ordemDeServico) {

		return OrdemDeServicoDTOOut.builder().id(ordemDeServico.getId())
				.dataInicioServico(ordemDeServico.getDataInicioServico())
				.dataFimServico(ordemDeServico.getDataFimServico())
				.clienteDTO(cDTOConverter.convert(ordemDeServico.getCliente()))
				.responsavel(
						ordemDeServico.getResponsavel() != null ? rDTOConverter.convert(ordemDeServico.getResponsavel())
								: null)
				.equipamentos(ordemDeServico.getEquipamentos() != null ? ordemDeServico.getEquipamentos().stream()
						.map(eDTOConverter::convert).collect(Collectors.toList()) : new ArrayList<>())
				.histAcompanhamentosDTO(
						ordemDeServico.getHistAcompanhamentos() != null ? ordemDeServico.getHistAcompanhamentos()
								.stream().map(haDTOConverter::convert).collect(Collectors.toList()) : new ArrayList<>())
				.build();
	}

}
