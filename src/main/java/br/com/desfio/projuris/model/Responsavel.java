package br.com.desfio.projuris.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_RESPONSAVEL")
@NoArgsConstructor
public class Responsavel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RESPONSAVEL", nullable = false)
	private Long id;

	@Column(name = "NOME_RESPONSAVEL", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "NUM_MAT_RESPONSAVEL", unique = true, nullable = false, length = 6)
	private String matricula;
	
	@OneToMany(mappedBy = "responsavel")
	private List<OrdemDeServico> ordens;

	public Responsavel(String nome) {
		this.nome = nome;
	}
}
