package br.com.rsds.ramaislist.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.rsds.ramaislist.exception.RecordNotFoundExceptiomn;
import br.com.rsds.ramaislist.model.RamaisList;
import br.com.rsds.ramaislist.repository.RamaisListRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Service
@Validated
public class RamaisListService {
	private final RamaisListRepository ramaisListRepository;

	public RamaisListService(RamaisListRepository ramaisListRepository) {
		this.ramaisListRepository = ramaisListRepository;
	}

	public List<RamaisList> list() {
		return ramaisListRepository.findAll();
	}

	public RamaisList FindbyId(@PathVariable @NotNull @Positive Long id) {
		return ramaisListRepository.findById(id).orElseThrow(() -> new RecordNotFoundExceptiomn(id));
	}

	public RamaisList create(@Valid RamaisList record) {
		return ramaisListRepository.save(record);
	}

	public RamaisList update(@NotNull @Positive Long id, @RequestBody @Valid RamaisList record) {
		return ramaisListRepository.findById(id).map(recordFind -> {
			recordFind.setName(record.getName());
			recordFind.setNumber(record.getNumber());
			recordFind.setContextPermission(record.getContextPermission());
			recordFind.setCaptureGroup(record.getCaptureGroup());
			recordFind.setDepartament(record.getDepartament());
			return ramaisListRepository.save(recordFind);
		}).orElseThrow(() -> new RecordNotFoundExceptiomn(id));
	}

	public void Delete(@PathVariable Long id) {
		ramaisListRepository
				.delete(ramaisListRepository.findById(id).orElseThrow(() -> new RecordNotFoundExceptiomn(id)));
	}
}
