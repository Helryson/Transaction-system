package com.transacao.teste.service;

import org.springframework.stereotype.Service;

import com.transacao.teste.DTO.ReciboDTO;
import com.transacao.teste.domain.entities.User;

@Service
public class EmailService {

	public ReciboDTO enviarEmailConcluido(User obj) {
		ReciboDTO comprovante = new ReciboDTO(obj, "Transação concluída com sucesso");
		return comprovante;
	}
	
}
