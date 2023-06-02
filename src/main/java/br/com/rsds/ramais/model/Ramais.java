package br.com.rsds.ramais.model;

import org.hibernate.validator.constraints.Length;

import br.com.rsds.ramais.enums.Paused;
import br.com.rsds.ramais.enums.converters.PausedConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "RAMAISLIST")
@Data
public class Ramais {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@NotBlank
	@Column(name = "NAME", nullable = false, length = 30)
	@Length(min = 1, max = 100)
	private String name;

	@NotNull
	@NotBlank
	@Column(name = "NUMBER", nullable = false, length = 4)
	@Length(min = 4, max = 4)
	private String number;

	@NotNull
	@NotBlank
	@Column(name = "CONTEXTPERMISSION", nullable = false, length = 24)
	private String contextPermission;

	@NotNull
	@NotBlank
	@Column(name = "CAPTUREGROUP", nullable = false, length = 10)
	private String captureGroup;

	@NotNull
	@NotBlank
	@Column(name = "DEPARTAMENT", nullable = false, length = 30)
	private String departament;

	@NotNull
	@Column(name = "PAUSED", nullable = false, length = 3)
	@Convert(converter = PausedConverter.class)
	private Paused paused = Paused.PAUSED_NAO;
}
