package com.cap.washer.repository;

import com.cap.washer.models.WasherInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface WasherInfoRepository extends MongoRepository<WasherInfo, Integer> {

    @Query("{'washerEmail' : ?0}")
    public WasherInfo findByWasherEmail(String email);

}
