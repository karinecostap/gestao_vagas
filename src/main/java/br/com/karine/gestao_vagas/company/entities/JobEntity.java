package br.com.karine.gestao_vagas.company.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity (name = "job")
@Data
public class JobEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private String benefits;

    @NotBlank(message = "O preenchimento do campo é obrigatório")
    private String level;

    @ManyToOne()
    @JoinColumn (name = "companyId", nullable = false)
    private CompanyEntity companyEntity;

    @Column(name = "companyId", insertable=false, updatable=false)
    private UUID companyId;

    @CreationTimestamp
    private LocalDateTime createdAt;


}
