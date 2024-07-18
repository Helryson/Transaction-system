package com.transacao.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transacao.teste.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
