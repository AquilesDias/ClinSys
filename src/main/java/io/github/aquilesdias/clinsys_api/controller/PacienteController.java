package io.github.aquilesdias.clinsys_api.controller;

import io.github.aquilesdias.clinsys_api.controller.dto.PacienteResponseDTO;
import io.github.aquilesdias.clinsys_api.domain.Paciente;
import io.github.aquilesdias.clinsys_api.mapper.PacienteMapper;
import io.github.aquilesdias.clinsys_api.service.PacienteService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/pacientes")
public class PacienteController {

    private final PacienteService service;
    private final PacienteMapper mapper;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> paciente(@RequestBody @Valid PacienteResponseDTO dto ){

        Paciente paciente = mapper.toEntity(dto);
        Paciente salvar = service.save(paciente);
        PacienteResponseDTO response = mapper.toDto(salvar);
        return ResponseEntity.ok(response);
    }

    @GetMapping(params = "id")
    public Paciente encontrarPacientePorId(@PathParam("id") Long id ){
        return service.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> TodosPacientes(){
        return ResponseEntity.ok(service.findAllPacientes());
    }

    @PutMapping("{id}")
    public ResponseEntity<Paciente> atualizarPaciente(
            @RequestBody Paciente paciente,
            @PathVariable Long id){

       return ResponseEntity.ok( service.updatePaciente(id, paciente) );
    }

    @DeleteMapping("{id}")
    public void deletarPaciente(@PathVariable Long id ){
        service.deletePaciente(id);
    }
}
