package com.tyrone.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.tyrone.cursomc.domain.Cliente;
import com.tyrone.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmation(Pedido pedido);
	void sendMail(SimpleMailMessage message);
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	void sendHtmlEmail(MimeMessage msg);
	void sendNewPasswordEmail(Cliente cliente, String newPass);
	
}
