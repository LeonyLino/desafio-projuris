package br.com.desfio.projuris.exceptions;

public class ResponsavelNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResponsavelNaoEncontradoException() {
		super("Responsavel Técnico não cadastrado.");
	}
}
