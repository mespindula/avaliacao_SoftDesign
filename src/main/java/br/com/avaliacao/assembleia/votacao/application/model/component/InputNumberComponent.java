package br.com.avaliacao.assembleia.votacao.application.model.component;

public class InputNumberComponent extends Component {

    private Integer valor;

    public InputNumberComponent() {
        super.setType("INPUT_NUMERO");
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
