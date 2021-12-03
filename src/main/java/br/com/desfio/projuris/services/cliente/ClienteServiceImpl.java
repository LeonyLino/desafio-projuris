package br.com.desfio.projuris.services.cliente;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.desfio.projuris.model.Cliente;
import br.com.desfio.projuris.model.dto.ClienteDTO;
import br.com.desfio.projuris.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

	private final ClienteRepository cRepository;
//	private final ClienteDTOConverter cDTOConverter;

	@Override
	@Transactional
	public Cliente salvar(ClienteDTO dto) {

		Cliente cliente = this.buscarPorCpf(dto.getCpf());

		if (cliente == null) {
			return cRepository.save(new Cliente(null, dto.getNome(), dto.getCpf(), dto.getEndereco(), dto.getTelefone(),
					dto.getEmail(), null));
		} else {
			return cliente;
		}

	}

	private Cliente buscarPorCpf(String cpf) {
		return cRepository.findByCpf(cpf);
	}

}
