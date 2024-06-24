package br.com.avaliacao.assembleia.votacao.domain.repository;

import br.com.avaliacao.assembleia.votacao.domain.data.subject.Subject;

import java.util.List;

public interface SubjectRepository {

    Subject create(Subject subject);
    Subject get(String uuid);
    List<Subject> getAll();
}
