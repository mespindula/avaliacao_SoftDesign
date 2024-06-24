package br.com.avaliacao.assembleia.votacao.infrastructure.integration.client;

import br.com.avaliacao.assembleia.votacao.infrastructure.data.model.integration.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "userInfoClient",
        url = "${integration.user-info.herokuapp.host}"
)
public interface UserInfoClient {

    @GetMapping(
            path = "${integration.user-info.herokuapp.api.get-user}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    UserInfo getUserInfo(
            @PathVariable("cpf") final String cpf);

}
