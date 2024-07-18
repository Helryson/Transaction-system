package com.transacao.teste.DTO;

import com.transacao.teste.domain.entities.User;

public class UserDTO {

	private Long id;
	private String nome;
	private String email;
	
	public UserDTO() {
		
	}

	public UserDTO(User obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
