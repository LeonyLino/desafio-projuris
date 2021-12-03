package br.com.desfio.projuris.exceptions;

public class OrdemDeServicoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrdemDeServicoNaoEncontradoException() {
		super("Ordem de Serviço não encontrado.");
	}

}
