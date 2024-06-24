package br.com.avaliacao.assembleia.votacao.application.model.component;

public class InputTextComponent extends Component {

    private String titile;
    private String value;

    public InputTextComponent() {
        super.setType("INPUT_TEXTO");
    }


    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
