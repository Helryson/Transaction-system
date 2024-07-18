package com.transacao.teste.domain.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String documento;
	private String email;
	private String senha;
	private Double saldo = 0.0;
	
	public User() {
		
	}
	
	public User(Long id, String nome, String email, String documento, String senha, Double saldo) {
		super();
		this.id = id;
		this.nome = nome;
		this.documento = documento;
		this.email = email;
		this.senha = senha;
		this.saldo = saldo;
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
	
	public String getDocumento() {
		return documento;
	}
	
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Double getSaldo() {
		return this.saldo;
	}
	
	 public void setSaldo(Double saldo) {
	        this.saldo = saldo;
	 }
	
	public void recebePagamento(Double saldo) {
		this.saldo += saldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	
}
