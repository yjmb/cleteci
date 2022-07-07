package com.cleteci.ejercicio.mapper;

import org.springframework.stereotype.Component;

import com.cleteci.ejercicio.entity.BookEntity;
import com.cleteci.ejercicio.model.Book;

@Component
public class CleteciMapper {
	public BookEntity bookToEntity(Book input) {
		BookEntity output = new BookEntity();
		output.setId(input.getId());
		output.setIsbn(input.getIsbn());
		output.setAuthor(input.getAuthor());
		output.setEditorial(input.getEditorial());
		output.setPageNumbers(input.getPageNumbers());
		output.setTitle(input.getTitle());
		return output;
	}

	public Book entityToBook(BookEntity input) {
		Book output = new Book();
		output.setId(input.getId());
		output.setIsbn(input.getIsbn());
		output.setAuthor(input.getAuthor());
		output.setEditorial(input.getEditorial());
		output.setPageNumbers(input.getPageNumbers());
		output.setTitle(input.getTitle());
		return output;
	}

}
