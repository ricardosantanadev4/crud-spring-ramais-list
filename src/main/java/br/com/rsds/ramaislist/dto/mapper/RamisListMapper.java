package br.com.rsds.ramaislist.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.rsds.ramaislist.dto.RamaisListDTO;
import br.com.rsds.ramaislist.model.RamaisList;

@Component
public class RamisListMapper {

	public RamaisListDTO toDTO(RamaisList ramalDTO) {

		if (ramalDTO == null) {
			return null;
		}

		return new RamaisListDTO(ramalDTO.getId(), ramalDTO.getName(), ramalDTO.getNumber(),
				ramalDTO.getContextPermission(), ramalDTO.getCaptureGroup(), ramalDTO.getDepartament());
	}

	public RamaisList toEntity(RamaisListDTO ramalDTO) {

		if (ramalDTO == null) {
			return null;
		}

		RamaisList ramal = new RamaisList();
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
