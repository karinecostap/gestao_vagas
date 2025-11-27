package br.com.karine.gestao_vagas.job.repositories;

import br.com.karine.gestao_vagas.job.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

}
