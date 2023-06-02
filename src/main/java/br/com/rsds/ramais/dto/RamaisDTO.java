package br.com.rsds.ramais.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RamaisDTO(
		Long id, 
		@NotNull @NotBlank String name, 
		@NotNull @NotBlank String number,
		@NotNull @NotBlank String contextPermission, 
		@NotNull @NotBlank String captureGroup,
		@NotNull @NotBlank String departament) {

}
