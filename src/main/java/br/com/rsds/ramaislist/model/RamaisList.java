package br.com.rsds.ramaislist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "RAMAISLIST")
@Data
public class RamaisList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "NAME", nullable = false, length = 30)
	private String name;
	@Column(name = "NUMBER", nullable = false, length = 4)
	private String number;
	@Column(name = "CONTEXTPERMISSION", nullable = false, length = 10)
	private String contextPermission;
	@Column(name = "CAPTUREGROUP", nullable = false, length = 10)
	private String captureGroup;
	@Column(name = "DEPARTAMENT", nullable = false, length = 30)
	private String departament;
	private String paused = Paused.NAO.toString();
}
