package br.com.avaliacao.assembleia.votacao.domain.services;

import br.com.avaliacao.assembleia.votacao.domain.exception.DataNotFoundException;
import br.com.avaliacao.assembleia.votacao.domain.repository.AssociateRepository;
import br.com.avaliacao.assembleia.votacao.domain.services.interfaces.AssociateService;
import org.springframework.stereotype.Service;

@Service
public class AssociateServiceImpl implements AssociateService {

    AssociateRepository associateRepository;


    public AssociateServiceImpl(AssociateRepository associateRepository) {
        this.associateRepository = associateRepository;
    }

    @Override
    public Boolean isValid(final String cpf) {
        if (associateRepository.isValid(cpf)) {
            return Boolean.TRUE;
        } else {
            throw new DataNotFoundException();
        }
    }
}
