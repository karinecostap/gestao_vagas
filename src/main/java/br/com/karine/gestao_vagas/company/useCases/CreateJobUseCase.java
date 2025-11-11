package br.com.karine.gestao_vagas.company.useCases;

import br.com.karine.gestao_vagas.company.entities.JobEntity;
import br.com.karine.gestao_vagas.company.repositories.CompanyRepository;
import br.com.karine.gestao_vagas.company.repositories.JobRepository;
import br.com.karine.gestao_vagas.exceptions.CompanyNotFoundException;
import br.com.karine.gestao_vagas.exceptions.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity jobEntity) {
        var company = this.companyRepository.findById(jobEntity.getCompanyId())
                .orElseThrow(() -> {
                    throw new CompanyNotFoundException();
                });
        jobEntity.setCompanyEntity(company);
        return this.jobRepository.save(jobEntity);
    }
}
