package br.com.desfio.projuris.controllers.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.desfio.projuris.model.Cliente;
import br.com.desfio.projuris.model.dto.ClienteDTO;
import br.com.desfio.projuris.model.dto.converter.ClienteDTOConverter;
import br.com.desfio.projuris.repository.ClienteRepository;
import br.com.desfio.projuris.services.cliente.ClienteServiceImpl;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

	@InjectMocks
	private ClienteServiceImpl pServiceImpl;

	@Mock
	private ClienteRepository cRepository;

	@Mock
	private ClienteDTOConverter cDTOConverter;

	@Test
	void deveriaRetornarUmClienteCadastrado() {
		Optional<Cliente> cOptional = Optional.of(new Cliente(1L, "LeonyLino", "3216549870", "rua fulano de tal",
				"8398563214", "leolino@mail.com", Mockito.anyList()));

		when(cRepository.findById(1L)).thenReturn(cOptional);
		Cliente clienteMock = cOptional.get();

		Cliente clienteTeste = pServiceImpl.salvar(this.convert(clienteMock));

		assertEquals(clienteMock, clienteTeste);
	}

	private ClienteDTO convert(Cliente cliente) {
		return ClienteDTO.builder().nome(cliente.getNome()).cpf(cliente.getCpf()).endereco(cliente.getEndereco())
				.telefone(cliente.getTelefone()).email(cliente.getEmail()).build();
	}
}
