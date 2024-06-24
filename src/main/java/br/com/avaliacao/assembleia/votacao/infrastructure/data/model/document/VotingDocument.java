package br.com.avaliacao.assembleia.votacao.infrastructure.data.model.document;

import br.com.avaliacao.assembleia.votacao.domain.data.serialization.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

@Document(collection = "voting")
public class VotingDocument {

    @MongoId
    private ObjectId id;

    @Indexed(unique = true)
    private String uuid;

    private String subjectUuid;

    private String associateCpf;

    private VotingDocumentEnum voting;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate createdDate;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSubjectUuid() {
        return subjectUuid;
    }

    public void setSubjectUuid(String subjectUuid) {
        this.subjectUuid = subjectUuid;
    }

    public String getAssociateCpf() {
        return associateCpf;
    }

    public void setAssociateCpf(String associateCpf) {
        this.associateCpf = associateCpf;
    }

    public VotingDocumentEnum getVoting() {
        return voting;
    }

    public void setVoting(VotingDocumentEnum voting) {
        this.voting = voting;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
