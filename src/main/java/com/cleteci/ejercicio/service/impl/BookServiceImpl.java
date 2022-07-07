package com.cleteci.ejercicio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cleteci.ejercicio.entity.BookEntity;
import com.cleteci.ejercicio.mapper.CleteciMapper;
import com.cleteci.ejercicio.model.Book;
import com.cleteci.ejercicio.model.GenericResponse;
import com.cleteci.ejercicio.repository.BookRepository;
import com.cleteci.ejercicio.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository repository;

	@Autowired
	private CleteciMapper mapper;

	@Override
	public GenericResponse createBook(Book book) {
		GenericResponse response = new GenericResponse<>();
		try {
			repository.save(mapper.bookToEntity(book));
			response.setCode(HttpStatus.OK.value());
			response.setMessage("Libro creado exitosamente");
		} catch (Exception e) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("Error creando libro. " + e.getMessage());
		}

		return response;
	}

	@Override
	public GenericResponse<List<Book>> getBookList() {
		GenericResponse<List<Book>> response = new GenericResponse<>();
		List<Book> bookList = new ArrayList<>();
		try {
			Iterable<BookEntity> books = repository.findAll();
			books.forEach(book -> {
				bookList.add(mapper.entityToBook(book));
			});
			response.setData(bookList);
			response.setCode(HttpStatus.OK.value());
			response.setMessage(HttpStatus.OK.getReasonPhrase());
		} catch (Exception e) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("Error obteniendo lista de libros. " + e.getMessage());
		}

		return response;
	}

	@Override
	public GenericResponse<Book> getBookById(Long bookId) {
		GenericResponse<Book> response = new GenericResponse<>();
		List<Book> bookList = new ArrayList<>();
		try {
			Optional<BookEntity> bookResponse = repository.findById(bookId);
			if (bookResponse.isPresent()) {
				BookEntity book = bookResponse.get();
				response.setData(mapper.entityToBook(book));
				response.setCode(HttpStatus.OK.value());
				response.setMessage(HttpStatus.OK.getReasonPhrase());
			} else {
				response.setCode(HttpStatus.NOT_FOUND.value());
				response.setMessage("Libro no encontrado");
			}

		} catch (Exception e) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("Error obteniendo libro. " + e.getMessage());
		}

		return response;
	}
	
	@Override
	public GenericResponse updateBook(Book book) {
		GenericResponse response = new GenericResponse<>();
		try {
			if (repository.existsById(book.getId())) {
				repository.save(mapper.bookToEntity(book));
				response.setCode(HttpStatus.OK.value());
				response.setMessage("Libro actualizado exitosamente");
			} else {
				response.setCode(HttpStatus.NOT_FOUND.value());
				response.setMessage("El Libro que desea actualizar no se encuentra en nuestra DB. Verifique el ID.");
			}

		} catch (Exception e) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("Error actualizando libro. " + e.getMessage());
		}

		return response;
	}

	@Override
	public GenericResponse deleteBook(Long bookId) {
		GenericResponse response = new GenericResponse<>();
		try {
			if (repository.existsById(bookId)) {
				repository.deleteById(bookId);
				response.setCode(HttpStatus.OK.value());
				response.setMessage("Libro eliminado exitosamente");
			} else {
				response.setCode(HttpStatus.NOT_FOUND.value());
				response.setMessage("El Libro que desea eliminar no se encuentra en nuestra DB. Verifique el ID.");
			}

		} catch (Exception e) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("Error eliminando libro. " + e.getMessage());
		}

		return response;
	}

}
