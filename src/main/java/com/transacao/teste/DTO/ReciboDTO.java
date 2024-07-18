package com.transacao.teste.DTO;

import java.io.Serializable;

import com.transacao.teste.domain.entities.User;

public class ReciboDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String mensagem;
	
	public ReciboDTO() {
		
	}
	
	public ReciboDTO(User obj, String mensagem) {
		super();
		this.email = obj.getEmail();
		this.mensagem = mensagem;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
