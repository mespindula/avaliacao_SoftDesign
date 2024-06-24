package br.com.avaliacao.assembleia.votacao.infrastructure.data.mapper;

import br.com.avaliacao.assembleia.votacao.domain.data.subject.Subject;
import br.com.avaliacao.assembleia.votacao.infrastructure.data.model.document.SubjectDocument;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubjectDocumentMapper {

    SubjectDocument convertToSubjectDocument(Subject subject);
    Subject convertToSubject(SubjectDocument associateDocument);
}
