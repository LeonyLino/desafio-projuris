package br.com.desfio.projuris.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTO {

	@NotNull
	@Size(min = 3, max = 100)
	private String nome;
	@CPF
	@NotNull
	private String cpf;
	private String endereco;
	private String telefone;
	@Email
	private String email;
}
