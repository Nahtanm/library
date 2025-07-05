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

import com.ncscode.library_api.entities.Reader;
import com.ncscode.library_api.service.ReaderService;

@RestController
@RequestMapping(value = "/readers")
public class ReaderResource {
	
	@Autowired
	private ReaderService readerService;
	
	@GetMapping
	public ResponseEntity<List<Reader>> findAll(){
		return ResponseEntity.ok().body(readerService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Reader> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(readerService.findById(id));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		readerService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Reader> inserir(@RequestBody Reader reader){
		readerService.inserir(reader);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(reader.getId()).toUri();
		return ResponseEntity.created(uri).body(reader);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Reader> update(@PathVariable Integer id, @RequestBody Reader reader) {
		return ResponseEntity.ok().body(readerService.update(id, reader));
	}
	
}
