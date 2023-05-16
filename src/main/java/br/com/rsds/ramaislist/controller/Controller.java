package br.com.rsds.ramaislist.controller;

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

import br.com.rsds.ramaislist.model.RamaisList;
import br.com.rsds.ramaislist.service.RamaisListService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/ramais-list")
public class Controller {
	private final RamaisListService ramaisListService;

	public Controller(RamaisListService ramaisListService) {
		this.ramaisListService = ramaisListService;
	}

	@GetMapping
	public @ResponseBody List<RamaisList> list() {
		List<RamaisList> ramais = ramaisListService.list();
		return ramais;
	}

	@GetMapping("/{id}")
	public RamaisList FindbyId(@PathVariable @NotNull @Positive Long id) {
		return ramaisListService.FindbyId(id);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public RamaisList create(@RequestBody @Valid RamaisList record) {
		return this.ramaisListService.create(record);
	}

	@PutMapping("/{id}")
	public RamaisList update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid RamaisList record) {
		return ramaisListService.update(id, record);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void Delete(@PathVariable @NotNull @Positive Long id) {
		ramaisListService.Delete(id);
	}
}
