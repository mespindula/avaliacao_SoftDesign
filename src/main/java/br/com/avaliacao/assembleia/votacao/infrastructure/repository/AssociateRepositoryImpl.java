package br.com.avaliacao.assembleia.votacao.infrastructure.repository;

import br.com.avaliacao.assembleia.votacao.domain.repository.AssociateRepository;
import br.com.avaliacao.assembleia.votacao.infrastructure.integration.client.UserInfoClient;
import org.springframework.stereotype.Component;

@Component
public class AssociateRepositoryImpl implements AssociateRepository {

    private final UserInfoClient userInfoClient;

    public AssociateRepositoryImpl(UserInfoClient userInfoClient) {
        this.userInfoClient = userInfoClient;
    }

    @Override
    public Boolean isValid(String cpf) {
        return userInfoClient.getUserInfo(cpf) != null;
    }
}
