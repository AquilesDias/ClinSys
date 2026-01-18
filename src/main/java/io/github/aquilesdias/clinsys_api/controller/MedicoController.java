package io.github.aquilesdias.clinsys_api.controller;

import io.github.aquilesdias.clinsys_api.controller.dto.MedicoResponseDTO;
import io.github.aquilesdias.clinsys_api.domain.Medico;
import io.github.aquilesdias.clinsys_api.mapper.MedicoMapper;
import io.github.aquilesdias.clinsys_api.service.MedicoService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/medicos")
public class MedicoController {

    private final MedicoService service;
    private final MedicoMapper medicoMapper;

    @PostMapping
    public ResponseEntity<MedicoResponseDTO> salvar(@RequestBody MedicoResponseDTO dto){

        Medico medico = medicoMapper.toEntity(dto);
        Medico novoMedico = service.save(medico);
        MedicoResponseDTO response = medicoMapper.toDto(novoMedico);
        return ResponseEntity.ok(response);

    }

    @GetMapping(params = "id")
    public MedicoResponseDTO encontrarMedicoPorId(@PathParam("id") Long id){
        Medico medico = service.findById(id).orElseThrow(() -> new RuntimeException("Medico não encontrado"));
        return medicoMapper.toDto(medico);
    }

    @PutMapping("{id}")
    public ResponseEntity<Medico> atualizarMedico(@RequestBody Medico medico, @PathVariable Long id ){
        return ResponseEntity.ok( service.updateMedico(medico, id) );
    }

    @DeleteMapping("{id}")
    public void deletarMedico(@PathVariable Long id){
        service.deleteById(id);
    }
}
