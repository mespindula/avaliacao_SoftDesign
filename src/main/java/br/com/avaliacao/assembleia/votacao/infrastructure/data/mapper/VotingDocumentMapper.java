package br.com.avaliacao.assembleia.votacao.infrastructure.data.mapper;

import br.com.avaliacao.assembleia.votacao.domain.data.voting.Voting;
import br.com.avaliacao.assembleia.votacao.infrastructure.data.model.document.VotingDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VotingDocumentMapper {

    @Mapping(target = "subjectUuid", source = "voting.subject.uuid")
    @Mapping(target = "associateCpf", source = "voting.associate.cpf")
    VotingDocument convertToVotingDocument(Voting voting);

    @Mapping(target = "subject.uuid", source = "subjectUuid")
    @Mapping(target = "associate.cpf", source = "associateCpf")
    Voting convertToVoting(VotingDocument votingDocument);
}
