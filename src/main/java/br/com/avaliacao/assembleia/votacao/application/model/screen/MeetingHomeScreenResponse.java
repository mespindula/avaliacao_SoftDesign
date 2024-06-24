package br.com.avaliacao.assembleia.votacao.application.model.screen;

import br.com.avaliacao.assembleia.votacao.application.model.component.ButtonComponent;
import br.com.avaliacao.assembleia.votacao.application.model.component.Component;
import br.com.avaliacao.assembleia.votacao.application.model.component.InputTextComponent;

import java.util.ArrayList;
import java.util.List;

public class MeetingHomeScreenResponse extends AbstractBasicScreen {

    @Override
    public ScreenResponse getScreen() {
        setType("FORMULARIO");
        setTitle("Home - Assembléia de Votação");

        InputTextComponent inputTextComponent = new InputTextComponent();
        inputTextComponent.setId("1");
        inputTextComponent.setTitile("Informe o CPF para acesso às pautas");

        List<Component> items = new ArrayList<>();
        items.add(inputTextComponent);

        ButtonComponent buttonComponent = new ButtonComponent();
        buttonComponent.setText("Acessar Pautas");
        buttonComponent.setUrl("http://assembleia.com/screen/subject/");

        setItems(items);
        setButtonComponent(buttonComponent);

        return this;
    }
}
