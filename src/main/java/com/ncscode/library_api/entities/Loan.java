package com.ncscode.library_api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.ncscode.library_api.entities.enums.LoanStatus;

public class Loan implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private LocalDate loanDate;
	private LoanStatus loanStatus;

	public Loan() {
	}

	public Loan(Integer id, LocalDate loanDate, LoanStatus loanStatus) {
		this.id = id;
		this.loanDate = loanDate;
		this.loanStatus = loanStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public LoanStatus getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(LoanStatus loanStatus) {
		this.loanStatus = loanStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		return Objects.equals(id, other.id);
	}
	
}
