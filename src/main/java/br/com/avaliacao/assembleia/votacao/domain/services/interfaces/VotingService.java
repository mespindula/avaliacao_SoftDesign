package br.com.avaliacao.assembleia.votacao.domain.services.interfaces;

import br.com.avaliacao.assembleia.votacao.application.model.VotingRequest;
import br.com.avaliacao.assembleia.votacao.application.model.screen.ScreenResponse;
import br.com.avaliacao.assembleia.votacao.domain.data.voting.VotingEnum;

public interface VotingService {

    ScreenResponse getScreen(String subjectUuid);
    void setVoting(String subjectUuid, VotingRequest votingRequest);
}
