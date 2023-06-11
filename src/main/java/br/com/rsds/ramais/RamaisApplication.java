package br.com.rsds.ramais;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.rsds.ramais.model.Ramais;
import br.com.rsds.ramais.repository.RamaisRepository;

@SpringBootApplication
public class RamaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RamaisApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(RamaisRepository ramaisListRepository) {
		return args -> {
			ramaisListRepository.deleteAll();
			Ramais ramais = new Ramais();
			ramais.setName("Ricardo - Desenvolvimento");
			ramais.setNumber("6000");
			ramais.setContextPermission("DDI");
			ramais.setCaptureGroup("1");
			ramais.setDepartament("DESENVOLVIMENTO");
			ramaisListRepository.save(ramais);
		};
	}
}
