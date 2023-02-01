package br.com.rsds.ramaislist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.rsds.ramaislist.model.Paused;
import br.com.rsds.ramaislist.model.RamaisList;
import br.com.rsds.ramaislist.repository.RamaisListRepository;

@SpringBootApplication
public class RamaisListApplication {

	public static void main(String[] args) {
		SpringApplication.run(RamaisListApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(RamaisListRepository ramaisListRepository) {
		return args -> {
			ramaisListRepository.deleteAll();
			RamaisList ramais = new RamaisList();
			ramais.setName("Ricardo - Desenvolvimento");
			ramais.setNumber("6000");
			ramais.setContextPermission("DDI");
			ramais.setCaptureGroup("1");
			ramais.setDepartament("DESENVOLVIMENTO");
			ramais.setPaused(Paused.NAO.toString());
			ramaisListRepository.save(ramais);
		};
	}
}
