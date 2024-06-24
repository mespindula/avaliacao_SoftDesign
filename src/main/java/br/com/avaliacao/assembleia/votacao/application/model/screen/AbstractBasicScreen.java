package br.com.avaliacao.assembleia.votacao.application.model.screen;

import br.com.avaliacao.assembleia.votacao.application.model.component.ButtonComponent;
import br.com.avaliacao.assembleia.votacao.application.model.component.Component;

import java.util.List;

public abstract class AbstractBasicScreen implements ScreenResponse {

    private String type;
    private String title;
    private List<Component> items;
    private String text;
    ButtonComponent buttonComponent;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Component> getItems() {
        return items;
    }

    public void setItems(List<Component> items) {
        this.items = items;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ButtonComponent getButtonComponent() {
        return buttonComponent;
    }

    public void setButtonComponent(ButtonComponent buttonComponent) {
        this.buttonComponent = buttonComponent;
    }
}
