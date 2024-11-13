package com.project.journalApp.repository;

import com.project.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// Spring boot injects implementation of these repositories at run time.
@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    // findByUserName is just declaration and not defination,
    // this is called QueryMethodDSL
    User findByUserName(String userName);

    void deleteByUserName(String username);
}
