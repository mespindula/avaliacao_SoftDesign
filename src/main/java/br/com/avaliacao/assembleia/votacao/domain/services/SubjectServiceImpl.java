package br.com.avaliacao.assembleia.votacao.domain.services;

import br.com.avaliacao.assembleia.votacao.application.model.screen.ScreenResponse;
import br.com.avaliacao.assembleia.votacao.application.model.screen.SubjectListScreenResponse;
import br.com.avaliacao.assembleia.votacao.domain.data.associate.Associate;
import br.com.avaliacao.assembleia.votacao.domain.data.subject.Subject;
import br.com.avaliacao.assembleia.votacao.domain.repository.SubjectRepository;
import br.com.avaliacao.assembleia.votacao.domain.services.interfaces.AssociateService;
import br.com.avaliacao.assembleia.votacao.domain.services.interfaces.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    AssociateService associateService;
    SubjectRepository subjectRepository;

    public SubjectServiceImpl(final AssociateService associateService,
                              final SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject create(final Subject subject) {
        return subjectRepository.create(subject);
    }

    @Override
    public Subject get(String uuid) {
        return subjectRepository.get(uuid);
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.getAll();
    }

    @Override
    public ScreenResponse getScreen(String cpf) {
        if (associateService.isValid(cpf)) {
            List<Subject> subjects = getAll();
            return new SubjectListScreenResponse().getScreen(subjects);
        }
        return new SubjectListScreenResponse().getScreen();
    }
}
