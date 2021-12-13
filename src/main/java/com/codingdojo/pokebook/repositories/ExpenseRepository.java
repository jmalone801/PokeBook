package com.codingdojo.pokebook.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.pokebook.models.Poke;

@Repository
public interface ExpenseRepository extends CrudRepository<Poke, Long>{
	
	List<Poke> findAll();

}
