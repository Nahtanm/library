package com.ncscode.library_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncscode.library_api.entities.Book;
import com.ncscode.library_api.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book findById(Integer id) {
		return bookRepository.findById(id).get();
	}

	public void delete(Integer id) {
		bookRepository.deleteById(id);
	}

	public Book inserir(Book book) {
		return bookRepository.save(book);
	}

	public Book update(Integer id, Book book) {
		Book entity = bookRepository.getReferenceById(id);
		updateData(entity, book);
		return bookRepository.save(entity);
	}

	private void updateData(Book entity, Book book) {
		entity.setAuthor(book.getAuthor());
		entity.setIsbn(book.getIsbn());
		entity.setTitle(book.getTitle());
	}
}
