package com.cleteci.ejercicio.service;

import java.util.List;

import com.cleteci.ejercicio.model.Book;
import com.cleteci.ejercicio.model.GenericResponse;

public interface BookService {
	GenericResponse createBook(Book book);
	
	GenericResponse<List<Book>> getBookList();
	
	GenericResponse<Book> getBookById(Long bookId);
	
	GenericResponse updateBook(Book book);
	
	GenericResponse deleteBook(Long bookId);
	
}
