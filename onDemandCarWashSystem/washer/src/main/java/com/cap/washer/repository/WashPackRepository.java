package com.cap.washer.repository;

import com.cap.washer.models.WashPack;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WashPackRepository extends MongoRepository<WashPack, String> {
        public  WashPack findByWashPackName(String washPackName);
}
