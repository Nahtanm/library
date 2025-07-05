package com.ncscode.library_api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.ncscode.library_api.entities.enums.LoanStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_loan")
public class Loan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate loanDate;
	private Integer loanStatus;

	@ManyToOne
	@JoinColumn(name = "reader_id")
	private Reader reader;

	@OneToMany(mappedBy = "id.loan")
	private List<LoanItem> items = new ArrayList<>();

	public Loan() {
	}

	public Loan(Integer id, LocalDate loanDate, LoanStatus loanStatus, Reader reader) {
		this.id = id;
		this.loanDate = loanDate;
		this.reader = reader;
		setLoanStatus(loanStatus);
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
		return LoanStatus.valueOf(loanStatus);
	}

	public void setLoanStatus(LoanStatus loanStatus) {
		this.loanStatus = loanStatus.getCode();
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public List<LoanItem> getItems() {
		return items;
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
