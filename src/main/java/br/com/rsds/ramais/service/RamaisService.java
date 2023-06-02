package br.com.rsds.ramais.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.rsds.ramais.dto.RamaisDTO;
import br.com.rsds.ramais.dto.mapper.RamisMapper;
import br.com.rsds.ramais.exception.RecordNotFoundExceptiomn;
import br.com.rsds.ramais.repository.RamaisRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Service
@Validated
public class RamaisService {
	private final RamaisRepository ramaisListRepository;
	private final RamisMapper ramisListMapper;

	public RamaisService(RamaisRepository ramaisListRepository, RamisMapper ramisListMapper) {
		this.ramaisListRepository = ramaisListRepository;
		this.ramisListMapper = ramisListMapper;
	}

	public List<RamaisDTO> list() {
		return ramaisListRepository.findAll().stream().map(ramisListMapper::toDTO).collect(Collectors.toList());
	}

	public RamaisDTO FindbyId(@PathVariable @NotNull @Positive Long id) {
		return ramaisListRepository.findById(id).map(ramisListMapper::toDTO)
				.orElseThrow(() -> new RecordNotFoundExceptiomn(id));
	}

	public RamaisDTO create(@Valid @NotNull RamaisDTO record) {
		return ramisListMapper.toDTO(ramaisListRepository.save(ramisListMapper.toEntity(record)));
	}

	public RamaisDTO update(@NotNull @Positive Long id, @RequestBody @Valid @NotNull RamaisDTO record) {
		return ramaisListRepository.findById(id).map(recordFind -> {
			recordFind.setName(record.name());
			recordFind.setNumber(record.number());
			recordFind.setContextPermission(record.contextPermission());
			recordFind.setCaptureGroup(record.captureGroup());
			recordFind.setDepartament(record.departament());
			return ramisListMapper.toDTO(ramaisListRepository.save(recordFind));
		}).orElseThrow(() -> new RecordNotFoundExceptiomn(id));
	}

	public void Delete(@PathVariable Long id) {
		ramaisListRepository
				.delete(ramaisListRepository.findById(id).orElseThrow(() -> new RecordNotFoundExceptiomn(id)));
	}
}
