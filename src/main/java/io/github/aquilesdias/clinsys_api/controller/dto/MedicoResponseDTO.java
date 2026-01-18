package io.github.aquilesdias.clinsys_api.controller.dto;

import jakarta.validation.constraints.*;

public record MedicoResponseDTO(

        @NotEmpty( message = "Campo NOM obrigatorio.")
        String nome,

        @Size(min = 6, max = 6)
        @Pattern(regexp = "^[0-9]+$", message = "Apenas números são permitidos")
        @NotEmpty( message = "Campo CRM obrigatorio.")
        String crm,

        @NotEmpty( message = "Campo ESPECIALIDADE obrigatorio.")
        String especialidade,

        @Email(message = "Campo E-MAIL invalido")
        String email
) {
}
