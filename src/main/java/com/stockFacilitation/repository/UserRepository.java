package com.stockFacilitation.repository;

import com.stockFacilitation.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String username);
}
