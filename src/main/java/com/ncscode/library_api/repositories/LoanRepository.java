package com.ncscode.library_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncscode.library_api.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

}
