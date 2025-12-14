package com.pilaka.order.service;

import com.pilaka.order.entity.Sequence;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SequenceGenerator {

    private final MongoOperations mongoOperations;

    public SequenceGenerator(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public int generateNextOrderId() {
        Sequence counter = mongoOperations.findAndModify(
                Query.query(Criteria.where("_id").is("sequence")),
                new Update().inc("sequence", 1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                Sequence.class
        );

        return counter != null ? counter.getSeq() : 1;
    }
}
