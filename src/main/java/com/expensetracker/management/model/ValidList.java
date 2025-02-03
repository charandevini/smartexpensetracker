package com.expensetracker.management.model;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Validated
public class ValidList<E> {
	@Valid
	private List<E> list;
}
