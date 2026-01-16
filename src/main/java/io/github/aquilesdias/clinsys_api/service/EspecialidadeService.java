package io.github.aquilesdias.clinsys_api.service;

import io.github.aquilesdias.clinsys_api.domain.Especialidade;
import io.github.aquilesdias.clinsys_api.repositories.EspecialidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EspecialidadeService {

    private final EspecialidadeRepository repository;


    public Especialidade save(Especialidade especialidade){
        return repository.save(especialidade);
    }

    public Optional<Especialidade> encontrarEspecialidadePorId(Long id){
        return repository.findById(id);
    }

    public Especialidade updateEspecialidade(Especialidade especialidade, Long id){

        Especialidade existEspecialidade = encontrarEspecialidadePorId(id).orElseThrow(
                () -> new RuntimeException("Especialidade não encontrada"));

        existEspecialidade.setNome(especialidade.getNome());
        existEspecialidade.setDescricao(especialidade.getDescricao());

        return repository.save(existEspecialidade);

    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
