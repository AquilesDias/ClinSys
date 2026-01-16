package io.github.aquilesdias.clinsys_api.repositories;

import io.github.aquilesdias.clinsys_api.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
