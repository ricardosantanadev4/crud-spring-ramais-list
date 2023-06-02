package br.com.rsds.ramais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rsds.ramais.model.Ramais;

@Repository
public interface RamaisRepository extends JpaRepository<Ramais, Long> {

}
