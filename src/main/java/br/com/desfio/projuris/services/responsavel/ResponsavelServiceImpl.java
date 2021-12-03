package br.com.desfio.projuris.services.responsavel;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.desfio.projuris.model.Responsavel;
import br.com.desfio.projuris.model.dto.ResponsavelDTO;
import br.com.desfio.projuris.repository.ResponsavelRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResponsavelServiceImpl implements ResponsavelService {

	private final ResponsavelRepository rRepository;

	@Transactional
	private Responsavel salvar(ResponsavelDTO dto) {
		return rRepository.save(new Responsavel(dto.getNome()));
	}

	@Override
	public Responsavel buscarPorMatricula(String matricula) {
		Optional<Responsavel> optionalResponsavel = rRepository.findByMatricula(matricula);

		if (optionalResponsavel.isPresent()) {
			return optionalResponsavel.get();
		}

		return new Responsavel();
	}

}
