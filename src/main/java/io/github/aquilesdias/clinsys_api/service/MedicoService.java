package io.github.aquilesdias.clinsys_api.service;

import io.github.aquilesdias.clinsys_api.controller.exceptions.MedicoComEspecialidadeDuplicada;
import io.github.aquilesdias.clinsys_api.domain.Medico;
import io.github.aquilesdias.clinsys_api.repositories.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MedicoService {

    private final MedicoRepository repository;


    public Medico save(Medico medico) {

        boolean exist = repository.existsByEspecialidadeId(medico.getEspecialidade().getId());

        if (exist) {
            throw new MedicoComEspecialidadeDuplicada(
                    "Especialidade já está cadastrada para outro médico"
            );
        }

        return repository.save(medico);
    }

    public Optional<Medico> findById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Medico updateMedico(Medico medico, Long id) {

        Medico existMedico = findById(id).orElseThrow(
                () -> new RuntimeException("Medico não encontrado"));

        existMedico.setNome(medico.getNome());
        existMedico.setEmail(medico.getEmail());
        existMedico.setEspecialidade(medico.getEspecialidade());
        existMedico.setCrm(medico.getCrm());

        return repository.save(existMedico);
    }
}
