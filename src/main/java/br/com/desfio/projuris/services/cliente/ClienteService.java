package br.com.desfio.projuris.services.cliente;

import br.com.desfio.projuris.model.Cliente;
import br.com.desfio.projuris.model.dto.ClienteDTO;

public interface ClienteService {

	Cliente salvar(ClienteDTO dto);

}
