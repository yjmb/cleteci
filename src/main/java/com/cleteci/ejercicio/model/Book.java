package com.cleteci.ejercicio.model;

import lombok.Data;

@Data
public class Book {
	private Long id;

	private String isbn;

	private String title;

	private String author;

	private String pageNumbers;

	private String editorial;
}
