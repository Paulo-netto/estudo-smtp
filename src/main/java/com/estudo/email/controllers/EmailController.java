package com.estudo.email.controllers;

import com.estudo.email.domain.Email;
import com.estudo.email.domain.dto.EmailDto;
import com.estudo.email.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity<?> enviarEmail(@RequestBody @Valid EmailDto emailDto) {
        var email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        emailService.enviarEmail(email);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }

}
