package com.ncscode.library_api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ncscode.library_api.entities.pk.LoanItemPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_loan_item")
public class LoanItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LoanItemPk id = new LoanItemPk();

	private Integer quantity;
	private LocalDate dueDate;

	public LoanItem() {
	}

	public LoanItem( Integer quantity, LocalDate dueDate, Book book, Loan loan) {
		id.setBook(book);
		id.setLoan(loan);
		this.quantity = quantity;
		this.dueDate = dueDate;
	}

	public Book getBook() {
		return id.getBook();
	}
	
	public void setBook(Book book) {
		id.setBook(book);
	}
	
	@JsonIgnore
	public Loan getLoan() {
		return id.getLoan();
	}
	
	public void setLoan(Loan loan) {
		id.setLoan(loan);
	}

	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
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
		LoanItem other = (LoanItem) obj;
		return Objects.equals(id, other.id);
	}

}
