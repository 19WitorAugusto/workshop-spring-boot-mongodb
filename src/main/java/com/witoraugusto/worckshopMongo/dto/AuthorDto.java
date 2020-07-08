package com.witoraugusto.worckshopMongo.dto;

import java.io.Serializable;

import com.witoraugusto.worckshopMongo.domain.User;

//mostrar somente o que quero
public class AuthorDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;

	public AuthorDto() {

	}

	public AuthorDto(User user) {
		id = user.getId();
		name = user.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
