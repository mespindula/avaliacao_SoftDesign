package br.com.avaliacao.assembleia.votacao.application.model.screen;

import br.com.avaliacao.assembleia.votacao.application.model.component.ButtonComponent;
import br.com.avaliacao.assembleia.votacao.application.model.component.Component;
import br.com.avaliacao.assembleia.votacao.application.model.component.SelectComponent;
import br.com.avaliacao.assembleia.votacao.domain.data.subject.Subject;
import br.com.avaliacao.assembleia.votacao.domain.data.voting.VotingEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VotingScrennResponse extends AbstractBasicScreen {

    @Override
    public ScreenResponse getScreen() {
        return null;
    }

    public ScreenResponse getScreen(Subject subject) {
        setType("SELECAO");
        setTitle("Pauta - Assembléia de Votação");
        setText(subject.getText());

        ButtonComponent buttonYes = new ButtonComponent();
        buttonYes.setText("SIM");

        ButtonComponent.Body bodyYes = new ButtonComponent().new Body();
        Map<String, Object> fieldYes = new HashMap();
        fieldYes.put("Sim", VotingEnum.YES);
        fieldYes.put("Não", VotingEnum.NO);
        bodyYes.setField(fieldYes);

        buttonYes.setBody(bodyYes);

        ButtonComponent buttonNo = new ButtonComponent();
        buttonYes.setText("NO");

        ButtonComponent.Body bodyNo = new ButtonComponent().new Body();
        Map<String, Object> fieldNo = new HashMap();
        fieldNo.put("Sim", VotingEnum.YES);
        fieldNo.put("Não", VotingEnum.NO);
        bodyNo.setField(fieldNo);

        buttonNo.setBody(bodyNo);

        setButtonComponent(buttonYes);
        setButtonComponent(buttonNo);

        return this;
    }

}
