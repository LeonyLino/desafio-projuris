package br.com.desfio.projuris.model.dto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.desfio.projuris.model.Cliente;
import br.com.desfio.projuris.model.dto.ClienteDTO;

@Component
public class ClienteDTOConverter implements Converter<Cliente, ClienteDTO> {

	
	@Override
	public ClienteDTO convert(Cliente cliente) {
		return ClienteDTO.builder().nome(cliente.getNome()).cpf(cliente.getCpf()).endereco(cliente.getEndereco())
				.telefone(cliente.getTelefone()).email(cliente.getEmail()).build();
	}

}
