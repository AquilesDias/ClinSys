package io.github.aquilesdias.clinsys_api.controller.dto;

import java.time.LocalDate;

public record PacienteResponseDTO(
        String nome,
        String cpf,
        LocalDate dtNascimento,
        String telefone,
        String endereco,
        String email) {
}
