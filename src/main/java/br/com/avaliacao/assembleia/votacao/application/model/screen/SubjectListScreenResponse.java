package br.com.avaliacao.assembleia.votacao.application.model.screen;

import br.com.avaliacao.assembleia.votacao.application.model.component.Component;
import br.com.avaliacao.assembleia.votacao.application.model.component.SelectComponent;
import br.com.avaliacao.assembleia.votacao.domain.data.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectListScreenResponse extends AbstractBasicScreen {


    @Override
    public ScreenResponse getScreen() {
        return this;
    }

    public ScreenResponse getScreen(List<Subject> subjects) {

        setType("SELECAO");
        setTitle("Pautas - Assembléia de Votação");

        List<Component> items = new ArrayList<>();
        subjects.forEach(subject -> {
            SelectComponent selectComponent = new SelectComponent();
            selectComponent.setText(subject.getText());
            selectComponent.setUrl("http://assembleia.com/screen/voting/"+subject.getUuid());
            items.add(selectComponent);
        });

        setItems(items);

        return this;
    }
}
