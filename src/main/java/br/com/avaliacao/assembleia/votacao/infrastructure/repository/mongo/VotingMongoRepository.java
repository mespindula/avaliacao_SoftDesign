package br.com.avaliacao.assembleia.votacao.infrastructure.repository.mongo;

import br.com.avaliacao.assembleia.votacao.infrastructure.data.model.document.VotingDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VotingMongoRepository extends MongoRepository<VotingDocument, ObjectId> {

    Optional<VotingDocument> findByUuidAndAssociateCpf(String uuid, String cpf);
}
