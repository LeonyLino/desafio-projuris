package br.com.desfio.projuris.specification;

import javax.persistence.criteria.Join;

import org.springframework.data.jpa.domain.Specification;

import br.com.desfio.projuris.model.OrdemDeServico;

public class OrdemDeServicoSpecification {

	public static Specification<OrdemDeServico> matriculaResponsavel(String matriculaResponsavel) {
		return (root, criteriaQuery, criteriaBuilder) -> {
			Join<Object, Object> join = root.join("responsavel");
			return criteriaBuilder.equal(join.get("matricula"), matriculaResponsavel);
		};
	}

	public static Specification<OrdemDeServico> nomeResponsavel(String nomeResponsavel) {
		return (root, criteriaQuery, criteriaBuilder) -> {
			Join<Object, Object> join = root.join("responsavel");
			return criteriaBuilder.equal(join.get("nome"), nomeResponsavel);
		};
	}

	public static Specification<OrdemDeServico> flagConcluido(Boolean flagConcluido) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("flConcluido"), flagConcluido);
	}

}
