package com.codingdojo.pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.pokebook.models.Poke;
import com.codingdojo.pokebook.services.ExpenseService;

@Controller
public class HomeController {

	@Autowired
	ExpenseService expenseService;
	
	@RequestMapping("/")
    public String index(Model model, @ModelAttribute("poke") Poke poke) {
        List<Poke> pokes = expenseService.allExpenses();
        model.addAttribute("pokes", pokes);
        return "index.jsp";
    }
	
	
	@PostMapping("/new")
	public String createExpense(@Valid @ModelAttribute("poke") Poke poke, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			expenseService.createExpense(poke);
			return "redirect:/";
		}
	}
	
    @RequestMapping("/poke/{id}/edit")
    public String editExpense(@PathVariable("id") Long id, Model model) {
        Poke poke = expenseService.findExpense(id);
        model.addAttribute("poke", poke);
        return "edit.jsp";
    }
    
    
    @RequestMapping(value="/poke/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("poke") Poke poke, 
    		BindingResult result) {
        if (result.hasErrors()) {
            return "/edit.jsp";
        } else {
        	expenseService.updateExpense(poke);
            return "redirect:/";
        }
    }

        
    @RequestMapping(value="/poke/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
    	expenseService.deleteExpense(id);
        return "redirect:/";
    }
    
    
    @RequestMapping("/poke/{id}/one")
    public String oneExpense(@PathVariable("id") Long id, Model model) {
        Poke poke = expenseService.oneExpense(id);
        model.addAttribute("poke", poke);
        return "oneExpense.jsp";
    }
    
    

	
	
}
