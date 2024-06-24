package br.com.avaliacao.assembleia.votacao.domain.repository;


public interface AssociateRepository {

    Boolean isValid(String cpf);
}
