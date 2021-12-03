package br.com.desfio.projuris.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_CLIENTE")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENTE", nullable = false)
	private Long id;

	@Column(name = "NOME_CLIENTE", nullable = false, length = 100)
	private String nome;

	@Column(name = "CPF_CLIENTE", nullable = false, length = 11)
	private String cpf;

	@Column(name = "ENDERECO_CLIENTE", nullable = false, length = 255)
	private String endereco;

	@Column(name = "TELEFONE_CLIENTE", nullable = false, length = 15)
	private String telefone;

	@Column(name = "EMAIL_CLIENTE", length = 100)
	private String email;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<OrdemDeServico> ordens;

}
