package br.com.desfio.projuris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desfio.projuris.model.HistoricoAcompanhamento;

@Repository
public interface HistoricoAcompanhamentoRepository extends JpaRepository<HistoricoAcompanhamento, Long> {

}
