package com.transacao.teste.domain.entities;

import jakarta.persistence.Entity;

@Entity
public class Lojista extends User {
	private static final long serialVersionUID = 1L;
	
	public Lojista() {
		
	}
	
	public Lojista(Long id, String nome, String email, String documento, String senha, Double saldo) {
		super(id, nome, email, documento, senha, saldo);
	}

}
