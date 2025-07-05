package com.ncscode.library_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncscode.library_api.entities.Reader;
import com.ncscode.library_api.repositories.ReaderRepository;

@Service
public class ReaderService {

	@Autowired
	private ReaderRepository readerRepository;
	
	public List<Reader> findAll(){
		return readerRepository.findAll();
	}
	
	public Reader findById(Integer id) {
		return readerRepository.findById(id).get();
	}
	
	public void delete(Integer id) {
		readerRepository.deleteById(id);
	}
	
	public Reader inserir(Reader reader){
		return readerRepository.save(reader);
	}
	
	public Reader update(Integer id, Reader reader) {
		Reader entity = readerRepository.getReferenceById(id);
		updateData(entity, reader);
		return readerRepository.save(entity);
	}

	private void updateData(Reader entity, Reader reader) {
		entity.setName(reader.getName());
		entity.setEmail(reader.getEmail());
		entity.setBirthDate(reader.getBirthDate());
	}
}
