package br.com.desfio.projuris.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

import br.com.desfio.projuris.utils.BooleanAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_ORDEM_SERVICO")
@AllArgsConstructor
@NoArgsConstructor
public class OrdemDeServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ORDEM", nullable = false)
	private Long id;

	@Column(name = "FL_CONCLUIDO_ORDEM", nullable = false, length = 1)
	@Convert(converter = BooleanAttributeConverter.class)
	private Boolean flConcluido;

	@Column(name = "DT_INICIO_SERVICO", nullable = false)
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime dataInicioServico;

	@Column(name = "DT_FIM_SERVICO", nullable = false)
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime dataFimServico;

	@ManyToOne
	@JoinColumn(name = "FK_CLIENTE", nullable = false)
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "FK_RESPONSAVEL", nullable = true)
	private Responsavel responsavel;

	@OneToMany(mappedBy = "ordemDeServico")
	private List<Equipamento> equipamentos;

	@OneToMany(mappedBy = "ordemDeServico")
	private List<HistoricoAcompanhamento> histAcompanhamentos;

	public OrdemDeServico(Cliente cliente, Responsavel responsavel) {
		this.cliente = cliente;
		this.responsavel = responsavel;
	}

}
