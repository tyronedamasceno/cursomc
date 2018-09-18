package com.tyrone.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tyrone.cursomc.domain.Cliente;
import com.tyrone.cursomc.repositories.ClienteRepository;
import com.tyrone.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		
		Cliente cliente = clienteRepository.findByEmail(email);
		if (cliente == null) {
			throw new ObjectNotFoundException("Email nao encontrado");
		}
		
		String newPass = newPassword();
		cliente.setSenha(encoder.encode(newPass));
		
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);		
	}

	private String newPassword() {
		String str = "";
		for (int i = 0; i < 10; i++) {
			str.concat(randomChar());
		}
		return str;
	}

	private String randomChar() {
		Long aux = System.currentTimeMillis();
		if (aux % 2 == 0) {
			return String.valueOf('0' + rand.nextInt(10));
		} else {
			return String.valueOf('a' + rand.nextInt(26));
		}
	}
	
}
