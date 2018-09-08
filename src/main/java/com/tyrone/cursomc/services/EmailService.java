package com.tyrone.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.tyrone.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmation(Pedido pedido);
	void sendMail(SimpleMailMessage message);
}
