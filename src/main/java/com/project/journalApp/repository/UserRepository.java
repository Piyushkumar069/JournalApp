package com.project.journalApp.repository;

import com.project.journalApp.entity.JournalEntry;
import com.project.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String userName);

    void deleteByUserName(String username);
}
