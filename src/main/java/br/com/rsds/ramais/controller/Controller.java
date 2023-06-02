package br.com.rsds.ramais.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rsds.ramais.dto.RamaisDTO;
import br.com.rsds.ramais.service.RamaisService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/ramais-list")
public class Controller {
	private final RamaisService ramaisListService;

	public Controller(RamaisService ramaisListService) {
		this.ramaisListService = ramaisListService;
	}

	@GetMapping
	public @ResponseBody List<RamaisDTO> list() {
		return ramaisListService.list();
	}

	@GetMapping("/{id}")
	public RamaisDTO FindbyId(@PathVariable @NotNull @Positive Long id) {
		return ramaisListService.FindbyId(id);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public RamaisDTO create(@RequestBody @Valid RamaisDTO record) {
		return ramaisListService.create(record);
	}

	@PutMapping("/{id}")
	public RamaisDTO update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid RamaisDTO record) {
		return ramaisListService.update(id, record);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void Delete(@PathVariable @NotNull @Positive Long id) {
		ramaisListService.Delete(id);
	}
}
