package com.tyrone.cursomc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SMTPEmailService extends AbstractEmailService{

	@Autowired
	private MailSender mailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(SMTPEmailService.class);
	
	@Override
	public void sendMail(SimpleMailMessage message) {
		LOG.info("Enviando email...");
		mailSender.send(message);
		LOG.info("Email enviado");
	}

}
