package br.com.avaliacao.assembleia.votacao.application.model.component;

public class TextComponent extends Component {

    private String text;

    public TextComponent() {
        super.setType("TEXTO");
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
