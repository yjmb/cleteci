package com.cleteci.ejercicio.rest.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cleteci.ejercicio.model.Book;
import com.cleteci.ejercicio.model.GenericResponse;
import com.cleteci.ejercicio.service.BookService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class CleteciRestController {
	@Autowired
	BookService service;

	@PutMapping(path = "/create-book", produces = "application/json")
	public GenericResponse createBook(@RequestBody Book request) {
		log.info("Inicio operacion para insertar un libro.");

		GenericResponse response = service.createBook(request);

		log.info("Fin operacion para insertar un libro");
		return response;
	}

	@GetMapping(path = "/get-all-books", produces = "application/json")
	public GenericResponse<List<Book>> getAllBooks() {
		log.info("Inicio operacion para listar todos los libros.");

		GenericResponse<List<Book>> response = service.getBookList();

		log.info("Fin operacion para listar todos los libros");
		return response;
	}

	@GetMapping(path = "/get-book-by-id", produces = "application/json")
	public GenericResponse<Book> getBookById(@RequestParam Long bookId) {
		log.info("Inicio operacion para obtener un libro dado su Id.");

		GenericResponse<Book> response = service.getBookById(bookId);

		log.info("Fin operacion para obtener un libro dado su Id");
		return response;
	}
	

	@PostMapping(path = "/update-book", produces = "application/json")
	public GenericResponse updateBook(@RequestBody Book request) {
		log.info("Inicio operacion para actualizar un libro.");

		GenericResponse response = service.updateBook(request);

		log.info("Fin operacion para actualiza un libro");
		return response;
	}

	@DeleteMapping(path = "/delete-book-by-id", produces = "application/json")
	public GenericResponse deleteBook(@RequestParam Long bookId) {
		log.info("Inicio operacion para eliminar un libro.");

		GenericResponse response = service.deleteBook(bookId);

		log.info("Fin operacion para eliminar un libro");
		return response;
	}

}
