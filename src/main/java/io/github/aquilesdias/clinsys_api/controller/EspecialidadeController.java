package io.github.aquilesdias.clinsys_api.controller;

import io.github.aquilesdias.clinsys_api.controller.dto.EspecialidadeDTO;
import io.github.aquilesdias.clinsys_api.domain.Especialidade;
import io.github.aquilesdias.clinsys_api.mapper.EspecialidadeMapper;
import io.github.aquilesdias.clinsys_api.service.EspecialidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/especialidades")
public class EspecialidadeController {

    private final EspecialidadeService service;
    private final EspecialidadeMapper especialidadeMapper;

    @PostMapping
    public ResponseEntity<EspecialidadeDTO> salvarEspecialidade(@RequestBody EspecialidadeDTO dto){

        Especialidade especialidade = service.save(especialidadeMapper.toEntity(dto));
        return ResponseEntity.ok(especialidadeMapper.toDto(especialidade));
    }

    @GetMapping(params = "id")
    public Especialidade buscarEspecialidadePorId(@RequestParam Long id){
        return service.encontrarEspecialidadePorId(id).orElseThrow(
                () -> new RuntimeException("Nenhuma especialidade encontrada"));
    }

    @PutMapping("{id}")
    public ResponseEntity<Especialidade> atualizarEspecidalidade(@RequestBody Especialidade especialidade, @PathVariable Long id){

        return ResponseEntity.ok(service.updateEspecialidade(especialidade, id));
    }

    @DeleteMapping("{id}")
    public void deletarEspecialidade(@PathVariable Long id){
        service.delete(id);
    }

}
