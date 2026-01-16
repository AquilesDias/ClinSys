package io.github.aquilesdias.clinsys_api.service;

import io.github.aquilesdias.clinsys_api.domain.Paciente;
import io.github.aquilesdias.clinsys_api.repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PacienteService {

    private final PacienteRepository repository;

    public Paciente save( Paciente paciente ){
        return repository.save(paciente);
    }

    public List<Paciente> findAllPacientes (){
        return repository.findAll();
    }

    public Optional<Paciente> findById ( Long id ){
        return repository.findById(id);
    }

    public Paciente updatePaciente(Long id, Paciente paciente){

        Paciente existsPaciente = findById(id).orElseThrow(()
                -> new RuntimeException("Paciente não encontrado"));

        existsPaciente.setNome(paciente.getNome());
        existsPaciente.setCpf(paciente.getCpf());
        existsPaciente.setDtNascimento(paciente.getDtNascimento());
        existsPaciente.setTelefone(paciente.getTelefone());
        existsPaciente.setEndereco(paciente.getEndereco());
        existsPaciente.setEmail(paciente.getEmail());

        return repository.save(existsPaciente);
    }

    public void deletePaciente(Long id){
        repository.deleteById(id);
    }

}
