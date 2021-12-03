package br.com.desfio.projuris.model.dto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.desfio.projuris.model.Responsavel;
import br.com.desfio.projuris.model.dto.ResponsavelDTO;

@Component
public class ResponsavelDTOConverter implements Converter<Responsavel, ResponsavelDTO> {
	
	@Override
	public ResponsavelDTO convert(Responsavel responsavel) {
		return ResponsavelDTO.builder().id(responsavel.getId()).nome(responsavel.getNome())
				.matricula(responsavel.getMatricula()).build();
	}

}
