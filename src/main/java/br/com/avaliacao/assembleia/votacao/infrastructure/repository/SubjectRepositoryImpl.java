package br.com.avaliacao.assembleia.votacao.infrastructure.repository;

import br.com.avaliacao.assembleia.votacao.domain.Util.DateProvider;
import br.com.avaliacao.assembleia.votacao.domain.Util.UuidProvider;
import br.com.avaliacao.assembleia.votacao.domain.data.subject.Subject;
import br.com.avaliacao.assembleia.votacao.domain.exception.DataNotFoundException;
import br.com.avaliacao.assembleia.votacao.domain.repository.SubjectRepository;
import br.com.avaliacao.assembleia.votacao.infrastructure.data.mapper.SubjectDocumentMapper;
import br.com.avaliacao.assembleia.votacao.infrastructure.data.model.document.SubjectDocument;
import br.com.avaliacao.assembleia.votacao.infrastructure.repository.mongo.SubjectMongoRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class SubjectRepositoryImpl implements SubjectRepository {

    private final SubjectMongoRepository subjectMongoRepository;
    private final SubjectDocumentMapper subjectDocumentMapper;
    private final DateProvider dateProvider;

    public SubjectRepositoryImpl(final SubjectMongoRepository subjectMongoRepository,
                                 final SubjectDocumentMapper subjectDocumentMapper,
                                 final DateProvider dateProvider) {
        this.subjectMongoRepository = subjectMongoRepository;
        this.subjectDocumentMapper = subjectDocumentMapper;
        this.dateProvider = dateProvider;
    }

    @Override
    public Subject create(final Subject subject) {
        SubjectDocument subjectDocument = subjectDocumentMapper.convertToSubjectDocument(subject);
        subjectDocument.setUuid(UuidProvider.get());
        subjectDocument.setCreatedDate(dateProvider.get());
        return subjectDocumentMapper.convertToSubject(subjectMongoRepository.save(subjectDocument));
    }

    @Override
    public Subject get(String uuid) {
        SubjectDocument subjectDocument = subjectMongoRepository.findByUuid(uuid).orElseThrow(DataNotFoundException::new);
        return subjectDocumentMapper.convertToSubject(subjectDocument);
    }

    @Override
    public List<Subject> getAll() {
        List<SubjectDocument> savedSubjectDocuments = subjectMongoRepository.findAll();

        if (savedSubjectDocuments.isEmpty()) {
            return Collections.emptyList();
        }

        final List<Subject> savedSubjects = new ArrayList<>();

        savedSubjectDocuments.forEach(doc -> {
            savedSubjects.add(subjectDocumentMapper.convertToSubject(doc));
        });

        return savedSubjects;
    }
}
