package com.colak.springtutorial.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@CompoundIndexes({
        @CompoundIndex(name = "timestamp_index", def = "{ 'timestamp': 1 }")
})
public class UserActivity {

    @Id
    private String id;
    private String userId;
    private long timestamp;
}
