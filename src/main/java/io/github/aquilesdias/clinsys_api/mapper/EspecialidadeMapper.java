package io.github.aquilesdias.clinsys_api.mapper;

import io.github.aquilesdias.clinsys_api.controller.dto.EspecialidadeDTO;
import io.github.aquilesdias.clinsys_api.domain.Especialidade;
import org.springframework.stereotype.Component;

@Component
public class EspecialidadeMapper {

    public Especialidade toEntity(EspecialidadeDTO dto){

        return new Especialidade(
                dto.nome(),
                dto.descricao()
        );
    }

    public EspecialidadeDTO toDto(Especialidade especialidade){

        return new EspecialidadeDTO(
                especialidade.getNome(),
                especialidade.getDescricao()
        );
    }


}
