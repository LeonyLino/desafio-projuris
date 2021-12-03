package br.com.desfio.projuris.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_EQUIPAMENTO")
@AllArgsConstructor
@NoArgsConstructor
public class Equipamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EQUIPAMENTO", nullable = false)
	private Long id;

	@Column(name = "TIPO_EQUIPAMENTO", nullable = false, length = 50)
	private String tipo;

	@Column(name = "MARCA_EQUIPAMENTO", nullable = false, length = 50)
	private String marca;

	@Column(name = "DS_PROBLEMA_EQUIPAMENTO", nullable = false, length = 255)
	private String descProblema;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_ORDEM_SERVICO", nullable = false)
	private OrdemDeServico ordemDeServico;

}
