package com.cleteci.ejercicio.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> {

	private Integer code;

	private String idMessage;

	private String message;

	private List<String> errors;

	private T data;

	public void addError(String error) {

		if (null == errors) {
			errors = new ArrayList<String>();
		}

		errors.add(error);

	}

}