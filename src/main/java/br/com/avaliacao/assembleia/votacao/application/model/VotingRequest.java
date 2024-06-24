package br.com.avaliacao.assembleia.votacao.application.model;

import br.com.avaliacao.assembleia.votacao.domain.data.validation.ValueOfEnum;
import br.com.avaliacao.assembleia.votacao.domain.data.voting.VotingEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class VotingRequest {

    @NotEmpty
    private String votingUuid;

    @NotEmpty
    private String cpf;

    @NotBlank
    @ValueOfEnum(enumClass = VotingEnum.class)
    private VotingEnum voting;

    public String getVotingUuid() {
        return votingUuid;
    }

    public void setVotingUuid(String votingUuid) {
        this.votingUuid = votingUuid;
    }

    public @NotEmpty String getCpf() {
        return cpf;
    }

    public void setCpf(@NotEmpty String cpf) {
        this.cpf = cpf;
    }

    public VotingEnum getVoting() {
        return voting;
    }

    public void setVoting(VotingEnum voting) {
        this.voting = voting;
    }
}
