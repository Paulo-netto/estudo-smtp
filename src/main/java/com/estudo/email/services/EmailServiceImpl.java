package com.estudo.email.services;

import com.estudo.email.domain.Email;
import com.estudo.email.domain.enums.StatusEmailEnum;
import com.estudo.email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private  EmailRepository repository;


    @Autowired
    private JavaMailSender enviarEmailJava;


    @Override
    public Email enviarEmail(Email email) {
        email.setDataEnvioEmail(LocalDateTime.now());
        try {
            var mensagem = criarMensagemEmail(email);
            enviarEmailJava.send(mensagem);
            email.setStatusEmail(StatusEmailEnum.ENVIADO);
        } catch (MailException e) {
            email.setStatusEmail(StatusEmailEnum.ERRO);
        } finally {
           return  repository.save(email);
        }
    }

    private SimpleMailMessage criarMensagemEmail(Email email) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(email.getOrigemEmail());
        msg.setTo(email.getDestinatarioEmail());
        msg.setSubject(email.getTituloEmail());
        msg.setText(email.getTexto());
        return msg;
    }
}
