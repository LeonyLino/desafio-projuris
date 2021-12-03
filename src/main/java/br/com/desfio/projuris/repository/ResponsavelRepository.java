package br.com.desfio.projuris.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desfio.projuris.model.Responsavel;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

	Optional<Responsavel> findByMatricula(String matricula);
}
