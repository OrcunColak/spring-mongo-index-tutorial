package com.colak.springtutorial.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserActivityAggregateRepository {

    private final MongoTemplate mongoTemplate;

    // Aggregation pipelines process data in stages, enabling highly efficient query execution.
    public Long countUserActivityInRange(long startTime, long endTime) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("timestamp").gte(startTime).lte(endTime)),
                Aggregation.group().count().as("total")
        );
        AggregationResults<Long> result = mongoTemplate.aggregate(aggregation, "userActivity", Long.class);
        return result.getUniqueMappedResult();
    }
}
