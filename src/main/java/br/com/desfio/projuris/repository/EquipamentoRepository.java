package br.com.desfio.projuris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desfio.projuris.model.Equipamento;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

}
