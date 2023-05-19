package br.com.rsds.ramaislist.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.rsds.ramaislist.dto.RamaisListDTO;
import br.com.rsds.ramaislist.dto.mapper.RamisListMapper;
import br.com.rsds.ramaislist.exception.RecordNotFoundExceptiomn;
import br.com.rsds.ramaislist.repository.RamaisListRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Service
@Validated
public class RamaisListService {
	private final RamaisListRepository ramaisListRepository;
	private final RamisListMapper ramisListMapper;

	public RamaisListService(RamaisListRepository ramaisListRepository, RamisListMapper ramisListMapper) {
		this.ramaisListRepository = ramaisListRepository;
		this.ramisListMapper = ramisListMapper;
	}

	public List<RamaisListDTO> list() {
		return ramaisListRepository.findAll().stream().map(ramisListMapper::toDTO).collect(Collectors.toList());
	}

	public RamaisListDTO FindbyId(@PathVariable @NotNull @Positive Long id) {
		return ramaisListRepository.findById(id).map(ramisListMapper::toDTO)
				.orElseThrow(() -> new RecordNotFoundExceptiomn(id));
	}

	public RamaisListDTO create(@Valid @NotNull RamaisListDTO record) {
		return ramisListMapper.toDTO(ramaisListRepository.save(ramisListMapper.toEntity(record)));
	}

	public RamaisListDTO update(@NotNull @Positive Long id, @RequestBody @Valid @NotNull RamaisListDTO record) {
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
