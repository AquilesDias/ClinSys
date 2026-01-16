package io.github.aquilesdias.clinsys_api.repositories;

import io.github.aquilesdias.clinsys_api.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
