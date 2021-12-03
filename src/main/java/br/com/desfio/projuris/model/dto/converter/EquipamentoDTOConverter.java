package br.com.desfio.projuris.model.dto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.desfio.projuris.model.Equipamento;
import br.com.desfio.projuris.model.dto.EquipamentoDTO;

@Component
public class EquipamentoDTOConverter implements Converter<Equipamento, EquipamentoDTO> {

	@Override
	public EquipamentoDTO convert(Equipamento equipamento) {
		return EquipamentoDTO.builder().id(equipamento.getId()).tipo(equipamento.getTipo())
				.marca(equipamento.getMarca()).descProblema(equipamento.getDescProblema()).build();
	}

}
