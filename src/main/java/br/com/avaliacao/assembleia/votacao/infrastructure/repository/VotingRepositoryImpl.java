package br.com.avaliacao.assembleia.votacao.infrastructure.repository;

import br.com.avaliacao.assembleia.votacao.domain.Util.DateProvider;
import br.com.avaliacao.assembleia.votacao.domain.Util.UuidProvider;
import br.com.avaliacao.assembleia.votacao.domain.data.subject.Subject;
import br.com.avaliacao.assembleia.votacao.domain.data.voting.Voting;
import br.com.avaliacao.assembleia.votacao.domain.data.voting.VotingEnum;
import br.com.avaliacao.assembleia.votacao.domain.repository.VotingRepository;
import br.com.avaliacao.assembleia.votacao.infrastructure.data.mapper.VotingDocumentMapper;
import br.com.avaliacao.assembleia.votacao.infrastructure.data.model.document.VotingDocument;
import br.com.avaliacao.assembleia.votacao.infrastructure.data.model.document.VotingDocumentEnum;
import br.com.avaliacao.assembleia.votacao.infrastructure.repository.mongo.VotingMongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VotingRepositoryImpl implements VotingRepository {

    private final VotingMongoRepository votingMongoRepository;
    private final VotingDocumentMapper votingDocumentMapper;
    private final DateProvider dateProvider;

    public VotingRepositoryImpl(final VotingMongoRepository votingMongoRepository,
                                final VotingDocumentMapper votingDocumentMapper,
                                final DateProvider dateProvider) {
        this.votingMongoRepository = votingMongoRepository;
        this.votingDocumentMapper = votingDocumentMapper;
        this.dateProvider = dateProvider;
    }

    @Override
    public Boolean existsSubjectUuidAndAssociateCpf(String subjectUuid, String cpf) {
        Optional<VotingDocument> votingDocument = votingMongoRepository.findByUuidAndAssociateCpf(subjectUuid, cpf);
        return votingDocument.isPresent();
    }

    @Override
    public Voting create(Subject subject, String associateCpf, VotingEnum voting) {
        VotingDocument document = new VotingDocument();
        document.setSubjectUuid(subject.getUuid());
        document.setAssociateCpf(associateCpf);
        document.setVoting(voting == VotingEnum.YES ? VotingDocumentEnum.YES : VotingDocumentEnum.NO);
        document.setUuid(UuidProvider.get());
        document.setCreatedDate(dateProvider.get());
        return votingDocumentMapper.convertToVoting(votingMongoRepository.save(document));
    }
}
