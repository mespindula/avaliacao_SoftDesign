package br.com.avaliacao.assembleia.votacao.domain.services.interfaces;

import br.com.avaliacao.assembleia.votacao.application.model.screen.ScreenResponse;
import br.com.avaliacao.assembleia.votacao.domain.data.subject.Subject;

import java.util.List;

public interface SubjectService {

    Subject create(Subject associate);
    Subject get(String uuid);
    List<Subject> getAll();
    ScreenResponse getScreen(String cpf);
}
