package br.com.avaliacao.assembleia.votacao.application.model.component;

import java.util.Map;

public class ButtonComponent extends Component {

    private String url;
    private Body body;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public class Body {
        private Map<String, Object> field;

        public Map<String, Object> getField() {
            return field;
        }

        public void setField(Map<String, Object> field) {
            this.field = field;
        }
    }

}
