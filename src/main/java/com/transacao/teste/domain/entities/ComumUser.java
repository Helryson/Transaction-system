package com.transacao.teste.domain.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ComumUSer")
public class ComumUser extends User{
	private static final long serialVersionUID = 1L;
	
	public ComumUser() {
		
	}
	
	public ComumUser(Long id, String nome, String email, String documento, String senha, Double saldo) {
		super(id, nome, email, documento, senha, saldo);
	}
	
	public void fazPagamento(Double valor) {
		double novoSaldo = getSaldo() - valor;
        setSaldo(novoSaldo);
	}
	
}
