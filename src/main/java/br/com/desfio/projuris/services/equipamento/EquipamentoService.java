package br.com.desfio.projuris.services.equipamento;

import java.util.List;

import br.com.desfio.projuris.model.Equipamento;
import br.com.desfio.projuris.model.OrdemDeServico;
import br.com.desfio.projuris.model.dto.EquipamentoDTO;

public interface EquipamentoService {

	List<Equipamento> salvar(List<EquipamentoDTO> dtos, OrdemDeServico ordem);
}
