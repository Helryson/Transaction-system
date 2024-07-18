package com.transacao.teste.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.transacao.teste.domain.entities.ComumUser;
import com.transacao.teste.domain.entities.User;
import com.transacao.teste.repository.UserRepository;
import com.transacao.teste.service.exception.TransactionException;

@Service
public class TransactionService {
	
private final UserRepository userRepo;
	
	public TransactionService(UserRepository userRepository) {
		this.userRepo = userRepository;
	}
	
	public void fazTransaction(ComumUser remetente, User destinatario, Double value){
		if(remetente.getSaldo() < value) {
			throw new TransactionException("Transação não pôde ser efetuada com sucesso. Saldo insuficiente");
		}
		remetente.fazPagamento(value);
		destinatario.recebePagamento(value);
		userRepo.saveAll(Arrays.asList(remetente, destinatario));
	}
	
}
