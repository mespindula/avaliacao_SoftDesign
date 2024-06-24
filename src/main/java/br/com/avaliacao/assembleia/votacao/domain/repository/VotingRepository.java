package br.com.avaliacao.assembleia.votacao.domain.repository;

import br.com.avaliacao.assembleia.votacao.domain.data.subject.Subject;
import br.com.avaliacao.assembleia.votacao.domain.data.voting.Voting;
import br.com.avaliacao.assembleia.votacao.domain.data.voting.VotingEnum;

public interface VotingRepository {

    Boolean existsSubjectUuidAndAssociateCpf(String subjectUuid, String associateCpf);
    Voting create(Subject subject, String associateCpf, VotingEnum voting);
}
