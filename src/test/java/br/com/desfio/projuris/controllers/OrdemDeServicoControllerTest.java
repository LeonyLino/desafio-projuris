package br.com.desfio.projuris.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.desfio.projuris.model.Cliente;
import br.com.desfio.projuris.model.OrdemDeServico;
import br.com.desfio.projuris.model.Responsavel;
import br.com.desfio.projuris.model.dto.ClienteDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrdemDeServicoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	private URI uri;
	private ObjectMapper objectMapper;
	OrdemDeServico ordem;
	Cliente cliente;
	ClienteDTO dto;
	
	@BeforeEach
	public void iniciar() throws URISyntaxException {
		this.objectMapper = new ObjectMapper();
		this.uri = new URI("/ordem");
		this.cliente = new Cliente(null, "LeonyLino", "12345678910", "rua fulano de tal", "839878556622",
				"leony@email.com", Mockito.anyList());
		this.ordem = new OrdemDeServico(new Cliente(), new Responsavel());
	}

	@Test
	void deveriaRetornarStatus400_QuandoCadastrarUmaNovaOrdemDeServicoSemClientre() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post(uri)
				.content(objectMapper.writeValueAsString(new OrdemDeServico(null, Boolean.FALSE, null, null,
						null, null, Mockito.anyList(), Mockito.anyList())))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(400));
	}
}
