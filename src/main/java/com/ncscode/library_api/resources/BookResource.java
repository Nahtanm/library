package com.ncscode.library_api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ncscode.library_api.entities.Book;
import com.ncscode.library_api.service.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookResource {
	
	@Autowired
	private BookService bookService;

	@GetMapping
	public ResponseEntity<List<Book>> findAll() {
		return ResponseEntity.ok().body(bookService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(bookService.findById(id));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		bookService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Book> inserir(@RequestBody Book book) {
		bookService.inserir(book);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getId()).toUri();
		return ResponseEntity.created(uri).body(book);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book book) {
		return ResponseEntity.ok().body(bookService.update(id, book));
	}
}
