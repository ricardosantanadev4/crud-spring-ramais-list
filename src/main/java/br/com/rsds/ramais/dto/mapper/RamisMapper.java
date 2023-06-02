package br.com.rsds.ramais.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.rsds.ramais.dto.RamaisDTO;
import br.com.rsds.ramais.model.Ramais;

@Component
public class RamisMapper {

	public RamaisDTO toDTO(Ramais ramalDTO) {

		if (ramalDTO == null) {
			return null;
		}

		return new RamaisDTO(ramalDTO.getId(), ramalDTO.getName(), ramalDTO.getNumber(),
				ramalDTO.getContextPermission(), ramalDTO.getCaptureGroup(), ramalDTO.getDepartament());
	}

	public Ramais toEntity(RamaisDTO ramalDTO) {

		if (ramalDTO == null) {
			return null;
		}

		Ramais ramal = new Ramais();
		if (ramalDTO.id() != null) {
			ramal.setId(ramalDTO.id());
		}

		ramal.setName(ramalDTO.name());
		ramal.setNumber(ramalDTO.number());
		ramal.setContextPermission(ramalDTO.contextPermission());
		ramal.setCaptureGroup(ramalDTO.captureGroup());
		ramal.setDepartament(ramalDTO.departament());
		return ramal;
	}

}
