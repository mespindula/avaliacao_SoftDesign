package br.com.avaliacao.assembleia.votacao.application.model.component;

public class SelectComponent extends Component {

    private String url;

    public SelectComponent() {
        super.setType("SELECAO");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
