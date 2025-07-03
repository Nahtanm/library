package com.ncscode.library_api.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ncscode.library_api.entities.Book;
import com.ncscode.library_api.entities.Loan;
import com.ncscode.library_api.entities.Reader;
import com.ncscode.library_api.entities.enums.LoanStatus;
import com.ncscode.library_api.repositories.BookRepository;
import com.ncscode.library_api.repositories.LoanRepository;
import com.ncscode.library_api.repositories.ReaderRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ReaderRepository readerRepository;

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		Reader r1 = new Reader(null, "Carlos Mendes", "carlos.mendes@example.com", LocalDate.of(1990, 3, 15));
		Reader r2 = new Reader(null, "Fernanda Lima", "fernanda.lima@example.com", LocalDate.of(1988, 10, 8));

		Loan l1 = new Loan(null, LocalDate.of(2025, 6, 1), LoanStatus.OPEN, r1);
		Loan l2 = new Loan(null, LocalDate.of(2025, 6, 15), LoanStatus.RETURNED, r1);
		Loan l3 = new Loan(null, LocalDate.of(2025, 6, 20), LoanStatus.LATE, r2);

		Book b1 = new Book(null, "Clean Code", "Robert C. Martin", "9780132350884", 10);
		Book b2 = new Book(null, "Design Patterns", "Erich Gamma", "9780201633610", 5);
		Book b3 = new Book(null, "Java: The Complete Reference", "Herbert Schildt", "9781260440232", 8);

		bookRepository.saveAll(Arrays.asList(b1,b2, b3));
		readerRepository.saveAll(Arrays.asList(r1, r2));
		loanRepository.saveAll(Arrays.asList(l1, l2, l3));

	}

}
