package com.ncscode.library_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncscode.library_api.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
