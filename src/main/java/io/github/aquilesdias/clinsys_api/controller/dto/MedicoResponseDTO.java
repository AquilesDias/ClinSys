package io.github.aquilesdias.clinsys_api.controller.dto;

public record MedicoResponseDTO(
        String nome,
        String crm,
        String especialidade,
        String email
) {
}
