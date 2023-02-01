package br.com.rsds.ramaislist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rsds.ramaislist.model.RamaisList;
import br.com.rsds.ramaislist.repository.RamaisListRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/ramais-list")
@AllArgsConstructor
public class Controller {
	RamaisListRepository ramaisListRepository;

	@GetMapping
	public List<RamaisList> list() {
		List<RamaisList> ramais = ramaisListRepository.findAll();
		return ramais;
	}
}
