package com.transacao.teste.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transacao.teste.DTO.ReciboDTO;
import com.transacao.teste.DTO.UserDTO;
import com.transacao.teste.domain.entities.ComumUser;
import com.transacao.teste.domain.entities.User;
import com.transacao.teste.resources.exception.InvalidResourceException;
import com.transacao.teste.service.EmailService;
import com.transacao.teste.service.TransactionService;
import com.transacao.teste.service.ValidationService;

@RestController
public class UserResources {
	
	@Autowired
	private final ValidationService validationService;
	
	@Autowired
	private final TransactionService transactionService;
	
	@Autowired
	private final EmailService emailService;
	
	public UserResources(ValidationService validationService, TransactionService transactionService, EmailService emailService) {
		this.validationService = validationService;
		this.transactionService = transactionService;
		this.emailService = emailService;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = validationService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/validarUsuario/{id}")
	public ResponseEntity<UserDTO> validaUsuario(@PathVariable Long id){
		User obj = validationService.findById(id);
		UserDTO objDTO = new UserDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}
	
	@PostMapping(value = "/envio")
	public ResponseEntity<ReciboDTO> fazEnvio(@RequestBody List<UserDTO> users, @RequestParam(value="valor", defaultValue="")String value){
	        double transactionValue = Double.parseDouble(value);
	        User remetente = validationService.findById(users.get(0).getId());
	        User destinatario = validationService.findById(users.get(1).getId());
	        if(remetente instanceof ComumUser) {
	        	transactionService.fazTransaction((ComumUser)remetente, destinatario, transactionValue);
	        	ReciboDTO recibo = emailService.enviarEmailConcluido(destinatario);
	        	return ResponseEntity.ok().body(recibo);
	        }
	        throw new InvalidResourceException("Remetente não possui permissão para essa transferência");
	        
	}
	
	
}
