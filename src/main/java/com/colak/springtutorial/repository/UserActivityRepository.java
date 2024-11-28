package com.colak.springtutorial.repository;

import com.colak.springtutorial.entity.UserActivity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserActivityRepository extends MongoRepository<UserActivity, String> {

    @Query("{ 'timestamp' : { $gte: ?0, $lte: ?1 } }")
    long countUserActivityInRange(long startTime, long endTime);
}
