package com.codingdojo.pokebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.codingdojo.pokebook.models.Poke;
import com.codingdojo.pokebook.repositories.ExpenseRepository;


@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	 
	 public ExpenseService(ExpenseRepository expenseRepository) {
	     this.expenseRepository = expenseRepository;
	 }
	 // Returns all things
	 public List<Poke> allExpenses() {
	     return expenseRepository.findAll();
	 }
	 // Creates one things
	 public Poke createExpense(Poke p) {
	     return expenseRepository.save(p);
	 }
	 
	 
	 // Edits one thing
	public Poke findExpense(Long id) {
		Optional<Poke> optionalpoke = expenseRepository.findById(id);
		if(optionalpoke.isPresent()) {
			return optionalpoke.get();
		} else {
			return null;
		}
	}
	
	// Returns edited thing
	public Poke updateExpense(Poke p) {
	     return expenseRepository.save(p);
	 }
	
	// Deletes one things
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
	
	// Returns one things
	public Poke oneExpense(Long id) {
		Optional<Poke> findOne = expenseRepository.findById(id);
		if(findOne.isPresent()) {
			return findOne.get();
		} else {
			return null;
		}
	}
	

}
