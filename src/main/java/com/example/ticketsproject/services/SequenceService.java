package com.example.ticketsproject.services;
import com.example.ticketsproject.domain.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Criteria;

@Service
public class SequenceService {

    @Autowired
    private MongoOperations mongoOperations;

    public long generateSequence(String sequenceName) {
        Sequence sequence = mongoOperations.findAndModify(
                Query.query(Criteria.where("_id").is(sequenceName)),
                new Update().inc("sequence", 1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                Sequence.class
        );
        return sequence != null ? sequence.getSequence() : 0;
    }

}
