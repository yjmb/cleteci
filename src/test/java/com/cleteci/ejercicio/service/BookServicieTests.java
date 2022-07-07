package com.cleteci.ejercicio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.cleteci.ejercicio.entity.BookEntity;
import com.cleteci.ejercicio.mapper.CleteciMapper;
import com.cleteci.ejercicio.model.Book;
import com.cleteci.ejercicio.model.GenericResponse;

@SpringBootTest
public class BookServicieTests {

	@Autowired
	BookService service;
	
	
	@Test
	void createBookTest() {
		Book book1 = new Book();
		book1.setIsbn("isbn001");
		book1.setTitle("The Jungle Book");
		book1.setEditorial("Macmillan Publishers");
		book1.setAuthor("Rudyard Kipling");
		book1.setPageNumbers("120");
		GenericResponse response1 = service.createBook(book1);
		
		Book book2 = new Book();
		book2.setIsbn("isbn002");
		book2.setTitle("La Cenicienta");
		book2.setEditorial("S.A. Editorial La Galera");
		book2.setAuthor("Charles Perrault");
		book2.setPageNumbers("120");
		GenericResponse response2 = service.createBook(book2);
		
		Assertions.assertEquals(200, response1.getCode());
		Assertions.assertEquals(200, response2.getCode());
	}
	
	@Test
	void createBookFailedTest() {
		GenericResponse response = service.createBook(null);		
		Assertions.assertEquals(500, response.getCode());
	}

	@Test
	void getBookListTest() {
		GenericResponse<List<Book>> response = service.getBookList();
		Assertions.assertEquals(200, response.getCode());
	}

	@Test
	void getBookByIdTest() {
		GenericResponse<Book> response = service.getBookById(Long.parseLong("1"));
		Assertions.assertEquals(200, response.getCode());
	}
	
	@Test
	void getBookByIdNotFoundTest() {
		GenericResponse<Book> response = service.getBookById(Long.parseLong("100"));
		Assertions.assertEquals(404, response.getCode());
	}

	@Test
	void updateBookTest() {	
		Book book = new Book();
		book.setId(Long.parseLong("1"));
		book.setIsbn("isbn001");
		book.setTitle("The Jungle Book");
		book.setEditorial("Macmillan Publishers");
		book.setAuthor("Rudyard Kipling");
		book.setPageNumbers("120");
		GenericResponse response1 = service.createBook(book);
		book.setTitle("The Jungle Book UPDATE");
		GenericResponse response = service.updateBook(book);
		Assertions.assertEquals(200, response.getCode());
	}

	@Test
	void deleteBookByIdTest() {
		GenericResponse response = service.deleteBook(Long.parseLong("2"));
		Assertions.assertEquals(200, response.getCode());
	}
	
	@Test
	void deleteBookByIdNotFoundTest() {
		GenericResponse response = service.deleteBook(Long.parseLong("200"));
		Assertions.assertEquals(404, response.getCode());
	}
}
