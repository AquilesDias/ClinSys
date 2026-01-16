package io.github.aquilesdias.clinsys_api.mapper;

import io.github.aquilesdias.clinsys_api.controller.dto.PacienteResponseDTO;
import io.github.aquilesdias.clinsys_api.domain.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public Paciente toEntity ( PacienteResponseDTO dto ) {

        return new Paciente(
                dto.nome(),
                dto.cpf(),
                dto.dtNascimento(),
                dto.telefone(),
                dto.endereco(),
                dto.email()
        );

    }

    public PacienteResponseDTO toDto( Paciente paciente ){

        return new PacienteResponseDTO(
                paciente.getNome(),
                paciente.getCpf(),
                paciente.getDtNascimento(),
                paciente.getTelefone(),
                paciente.getEndereco(),
                paciente.getEmail()
        );
    }



}
