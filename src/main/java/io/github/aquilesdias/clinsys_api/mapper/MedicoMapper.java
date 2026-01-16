package io.github.aquilesdias.clinsys_api.mapper;

import io.github.aquilesdias.clinsys_api.controller.dto.MedicoResponseDTO;
import io.github.aquilesdias.clinsys_api.domain.Medico;
import org.springframework.stereotype.Component;

@Component
public class MedicoMapper {

    public Medico toEntity( MedicoResponseDTO dto ) {

        return new Medico(
                dto.nome(),
                dto.crm(),
                dto.especialidade(),
                dto.email()
        );
    }

    public MedicoResponseDTO toDto(Medico medico){

        return new MedicoResponseDTO(
                medico.getNome(),
                medico.getCrm(),
                medico.getEspecialidade(),
                medico.getEmail()
        );
    }

}
