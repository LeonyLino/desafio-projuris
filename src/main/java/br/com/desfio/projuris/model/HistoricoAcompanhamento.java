package br.com.desfio.projuris.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_HISTORICO_ACOMPANHAMENTO")
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoAcompanhamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_HIST_ACOMPANHAMENTO", nullable = false)
	private Long id;

	@Column(name = "DS_OBSERVACAO_HIST_ACOMPANHAMENTO", nullable = true, length = 255)
	private String descObservacao;

	@Column(name = "DT_HIST_ACOMPANHAMENTO", nullable = false)
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime data;

	@ManyToOne
	@JoinColumn(name = "FK_ORDEM_SERVICO", nullable = false)
	private OrdemDeServico ordemDeServico;

}
