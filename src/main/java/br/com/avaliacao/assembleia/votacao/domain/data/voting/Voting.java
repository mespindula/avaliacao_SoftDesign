package br.com.avaliacao.assembleia.votacao.domain.data.voting;

import br.com.avaliacao.assembleia.votacao.domain.data.associate.Associate;
import br.com.avaliacao.assembleia.votacao.domain.data.subject.Subject;

public class Voting {

    private String uuid;
    private Subject subject;
    private Associate associate;
    private VotingEnum voting;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Associate getAssociate() {
        return associate;
    }

    public void setAssociate(Associate associate) {
        this.associate = associate;
    }

    public VotingEnum getVoting() {
        return voting;
    }

    public void setVoting(VotingEnum voting) {
        this.voting = voting;
    }
}
