package com.cleteci.ejercicio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_book")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String isbn;

	private String title;

	private String author;

	private String pageNumbers;

	private String editorial;
}
