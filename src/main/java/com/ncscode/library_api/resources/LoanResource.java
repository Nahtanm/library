package com.ncscode.library_api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncscode.library_api.entities.Loan;
import com.ncscode.library_api.service.LoanService;

@RestController
@RequestMapping(value = "/loans")
public class LoanResource {

	@Autowired
	private LoanService loanService;
	
	@GetMapping
	public ResponseEntity<List<Loan>> findAll(){
		return ResponseEntity.ok().body(loanService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Loan> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(loanService.findById(id));
	}
}
