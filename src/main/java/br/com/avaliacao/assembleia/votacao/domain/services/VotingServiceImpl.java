package br.com.avaliacao.assembleia.votacao.domain.services;

import br.com.avaliacao.assembleia.votacao.application.model.VotingRequest;
import br.com.avaliacao.assembleia.votacao.application.model.screen.ScreenResponse;
import br.com.avaliacao.assembleia.votacao.application.model.screen.VotingScrennResponse;
import br.com.avaliacao.assembleia.votacao.domain.data.subject.Subject;
import br.com.avaliacao.assembleia.votacao.domain.exception.DataAlreadyRegisteredException;
import br.com.avaliacao.assembleia.votacao.domain.repository.VotingRepository;
import br.com.avaliacao.assembleia.votacao.domain.services.interfaces.SubjectService;
import br.com.avaliacao.assembleia.votacao.domain.services.interfaces.VotingService;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class VotingServiceImpl implements VotingService {

    private SubjectService subjectService;
    private VotingRepository votingRepository;

    public VotingServiceImpl(final SubjectService subjectService,
                             final VotingRepository votingRepository) {
        this.subjectService = subjectService;
        this.votingRepository = votingRepository;
    }

    @Override
    public ScreenResponse getScreen(String subjectUuid)  {
        Subject subject = subjectService.get(subjectUuid);
        return new VotingScrennResponse().getScreen(subject);
    }

    @Override
    public void setVoting(String subjectUuid, VotingRequest votingRequest) {

        if (votingRepository.existsSubjectUuidAndAssociateCpf(subjectUuid, votingRequest.getCpf())) {
            throw new DataAlreadyRegisteredException(
                    MessageFormat.format(
                            "O associado CPF {0} já votou anteriormente na pauta {1}",
                            votingRequest.getCpf(),
                            subjectUuid));
        }

        Subject subject = subjectService.get(subjectUuid);
        votingRepository.create(subject, votingRequest.getCpf(), votingRequest.getVoting());
    }


}
