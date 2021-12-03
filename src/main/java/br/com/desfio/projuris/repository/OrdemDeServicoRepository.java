package br.com.desfio.projuris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.desfio.projuris.model.OrdemDeServico;

@Repository
public interface OrdemDeServicoRepository
		extends JpaRepository<OrdemDeServico, Long>, JpaSpecificationExecutor<OrdemDeServico> {

}
