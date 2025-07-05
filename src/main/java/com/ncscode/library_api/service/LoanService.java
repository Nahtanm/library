package com.ncscode.library_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncscode.library_api.entities.Loan;
import com.ncscode.library_api.repositories.LoanRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository;
	
	public List<Loan> findAll(){
		return loanRepository.findAll();
	}
	
	public Loan findById(Integer id) {
		return loanRepository.findById(id).get();
	}
	
	
}


