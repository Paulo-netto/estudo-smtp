package com.estudo.email.domain;

import com.estudo.email.domain.enums.StatusEmailEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmail;

    private String referenciaProprietario;
    private String origemEmail;
    private String destinatarioEmail;
    private String tituloEmail;
    @Column(columnDefinition = "TEXT" )
    private String texto;

    private LocalDateTime dataEnvioEmail;
    private StatusEmailEnum statusEmail;


}
