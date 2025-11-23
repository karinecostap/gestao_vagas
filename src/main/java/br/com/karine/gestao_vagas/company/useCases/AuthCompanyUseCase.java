package br.com.karine.gestao_vagas.company.useCases;

import br.com.karine.gestao_vagas.company.dto.AuthCompanyDTO;
import br.com.karine.gestao_vagas.company.repositories.CompanyRepository;
import br.com.karine.gestao_vagas.exceptions.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.sasl.AuthenticationException;

@Service
public class AuthCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Company not found"));

        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(),company.getPassword());

        if(!passwordMatches) {
            throw new AuthenticationException();
        }

    }



}
