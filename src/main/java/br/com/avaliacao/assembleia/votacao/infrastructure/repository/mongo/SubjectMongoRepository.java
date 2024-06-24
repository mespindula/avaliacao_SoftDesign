package br.com.avaliacao.assembleia.votacao.infrastructure.repository.mongo;

import br.com.avaliacao.assembleia.votacao.infrastructure.data.model.document.SubjectDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectMongoRepository extends MongoRepository<SubjectDocument, ObjectId>  {

    Optional<SubjectDocument> findByUuid(String uuid);
}
