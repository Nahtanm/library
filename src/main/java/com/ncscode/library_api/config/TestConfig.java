package com.ncscode.library_api.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ncscode.library_api.entities.Loan;
import com.ncscode.library_api.entities.Reader;
import com.ncscode.library_api.entities.enums.LoanStatus;
import com.ncscode.library_api.repositories.LoanRepository;
import com.ncscode.library_api.repositories.ReaderRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ReaderRepository readerRepository;

	@Autowired
	private LoanRepository loanRepository;

	@Override
	public void run(String... args) throws Exception {
		Reader r1 = new Reader(null, "Carlos Mendes", "carlos.mendes@example.com", LocalDate.of(1990, 3, 15));
		Reader r2 = new Reader(null, "Fernanda Lima", "fernanda.lima@example.com", LocalDate.of(1988, 10, 8));

		Loan l1 = new Loan(null, LocalDate.of(2025, 6, 1), LoanStatus.OPEN);
		Loan l2 = new Loan(null, LocalDate.of(2025, 6, 15), LoanStatus.RETURNED);
		Loan l3 = new Loan(null, LocalDate.of(2025, 6, 20), LoanStatus.LATE);

		readerRepository.saveAll(Arrays.asList(r1, r2));
		loanRepository.saveAll(Arrays.asList(l1, l2, l3));

	}

}
