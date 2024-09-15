package com.estudo.email.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDto {

    @NotBlank
    private String referenciaProprietario;
    @NotBlank
    @Email
    private String origemEmail;
    @NotBlank
    @Email
    private String destinatarioEmail;
    @NotBlank
    private String tituloEmail;
    @NotBlank
    private String texto;
}
