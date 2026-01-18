package io.github.aquilesdias.clinsys_api.controller.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record PacienteResponseDTO(

        @NotEmpty( message = "Campo NOME obrigatorio.")
        String nome,

        @CPF
        String cpf,

        @NotNull( message = "Campo DATA NASCIMENTO obrigatorio.")
        LocalDate dtNascimento,

        @Pattern(regexp = "^[0-9]+$", message = "Campo TELEFONE obrigatorio.")
        String telefone,
        String endereco,

        @Email
        String email) {
}
