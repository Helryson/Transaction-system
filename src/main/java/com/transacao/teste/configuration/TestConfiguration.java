package com.transacao.teste.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.transacao.teste.domain.entities.ComumUser;
import com.transacao.teste.domain.entities.Lojista;
import com.transacao.teste.domain.entities.User;
import com.transacao.teste.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new ComumUser(null, "joaquim", "joaquim@gmail.com", "123456789-11", "12234567", 0.0);
		User user2 = new Lojista(null, "fernanda", "fernanda@gmail.com", "123456789-11", "12234567", 0.0);
		
		user1.recebePagamento(2000.0);
		
		userRepo.saveAll(Arrays.asList(user1, user2));
		
		
	}

	
}
