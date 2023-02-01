package br.com.rsds.ramaislist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rsds.ramaislist.model.RamaisList;

@Repository
public interface RamaisListRepository extends JpaRepository<RamaisList, Long> {

}
