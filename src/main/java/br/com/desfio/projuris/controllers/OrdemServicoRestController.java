package br.com.desfio.projuris.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desfio.projuris.exceptions.OrdemDeServicoNaoEncontradoException;
import br.com.desfio.projuris.model.Erro;
import br.com.desfio.projuris.model.dto.OrdemDeServicoDTOIn;
import br.com.desfio.projuris.model.dto.OrdemDeServicoDTOOut;
import br.com.desfio.projuris.services.ordemservico.OrdemDeServicoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ordem")
public class OrdemServicoRestController {

	private final OrdemDeServicoService odsService;

	@PostMapping
	public ResponseEntity<OrdemDeServicoDTOOut> cadastrar(@RequestBody @Valid OrdemDeServicoDTOIn dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(odsService.cadastrar(dto));
	}

	@GetMapping("/pesquisar")
	public List<OrdemDeServicoDTOOut> listarPorFiltros(@RequestBody OrdemDeServicoDTOIn dto) {
		return odsService.buscarPorFiltros(dto);
	}

	@GetMapping("/listar")
	public List<OrdemDeServicoDTOOut> listar() {
		return odsService.listar();
	}

	@PutMapping
	public ResponseEntity<Object> iniciarEFinalizarServico(@RequestBody OrdemDeServicoDTOIn dto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(odsService.iniciarEFinalizarServico(dto));
		} catch (OrdemDeServicoNaoEncontradoException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new Erro(HttpStatus.NOT_FOUND.value(), e.getMessage()));
		}
	}

	@PostMapping("addObservacao")
	public ResponseEntity<Object> cadastrarObservacao(@RequestBody OrdemDeServicoDTOIn dto) {
		try {
			odsService.cadastrarNovaObservacao(dto);
			return ResponseEntity.ok("ok");
		} catch (OrdemDeServicoNaoEncontradoException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new Erro(HttpStatus.NOT_FOUND.value(), e.getMessage()));
		}
	}
}
