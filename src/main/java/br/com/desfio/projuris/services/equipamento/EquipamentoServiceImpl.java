package br.com.desfio.projuris.services.equipamento;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.desfio.projuris.model.Equipamento;
import br.com.desfio.projuris.model.OrdemDeServico;
import br.com.desfio.projuris.model.dto.EquipamentoDTO;
import br.com.desfio.projuris.repository.EquipamentoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipamentoServiceImpl implements EquipamentoService {

	private final EquipamentoRepository eRepository;

	@Override
	@Transactional
	public List<Equipamento> salvar(List<EquipamentoDTO> dtos, OrdemDeServico ordem) {
		List<Equipamento> equipamentos = new ArrayList<>();
		dtos.stream().forEach(dto -> equipamentos
				.add(eRepository.save(new Equipamento(null, dto.getTipo(), dto.getMarca(), dto.getDescProblema(), ordem)))

		);

		return equipamentos;
	}

}
