package io.github.aquilesdias.clinsys_api.mapper;

import io.github.aquilesdias.clinsys_api.controller.dto.MedicoResponseDTO;
import io.github.aquilesdias.clinsys_api.domain.Especialidade;
import io.github.aquilesdias.clinsys_api.domain.Medico;
import io.github.aquilesdias.clinsys_api.repositories.EspecialidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MedicoMapper {

    private final EspecialidadeRepository especialidadeRepository;

    public Medico toEntity( MedicoResponseDTO dto ) {

        Especialidade especialidade = especialidadeRepository
                .findByNome(dto.especialidade())
                .orElseThrow(() -> new RuntimeException("Especialidade não encontrada"));

        return new Medico(
                dto.nome(),
                dto.crm(),
                especialidade,
                dto.email()
        );
    }

    public MedicoResponseDTO toDto(Medico medico){

        return new MedicoResponseDTO(
                medico.getNome(),
                medico.getCrm(),
                medico.getEspecialidade().getNome(),
                medico.getEmail()
        );
    }

}
