package com.cleteci.ejercicio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cleteci.ejercicio.entity.BookEntity;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
	
	List<BookEntity> findByIsbn(String isbn);
	
	List<BookEntity> findByTitle(String title);
	
	List<BookEntity> findByAuthor(String author);
}
