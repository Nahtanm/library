package com.ncscode.library_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncscode.library_api.entities.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Integer>{

}
