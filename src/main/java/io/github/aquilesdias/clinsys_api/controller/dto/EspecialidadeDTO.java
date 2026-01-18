package io.github.aquilesdias.clinsys_api.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record EspecialidadeDTO(


        @Size(min = 5, max = 20, message = "Campo NOME o tamanho deve ser entre 5 e 20")
        String nome,

        @NotEmpty( message = "Campo DESCRICAO obrigatorio.")
        @Size(min = 5, max = 100)
        String descricao
) {
}
