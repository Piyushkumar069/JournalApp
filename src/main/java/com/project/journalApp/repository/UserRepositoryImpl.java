package com.project.journalApp.repository;

import com.project.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

// till now, we were interacting with mongo db using repositories now we will use criteria
public class UserRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

//    public List<User> getUserForSA(){
//        Query query = new Query();
////        query.addCriteria(Criteria.where("userName").is("vipul"));
////        below on both the criteria "and" conditions exists, but we can manually add "or" conditions
////        query.addCriteria(Criteria.where("email").exists(true));
////        query.addCriteria(Criteria.where("email").ne(null).ne(""));
//
////        It checks regular expression of email that it is valid email or not
//        query.addCriteria(Criteria.where("email").regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n"));
//        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));
//
////        or conditions
////        Criteria criteria = new Criteria();
////        query.addCriteria(criteria.orOperator(Criteria.where("email").exists(true),
////                Criteria.where("sentimentAnalysis").is(true)));
////        It will automatically detect on which collection it needs to run the query
////        from just giving the class name.
//        List<User> users = mongoTemplate.find(query, User.class);
//        return users;
//    }
    public List<User> getUserForSA() {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$"));
        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));
        return mongoTemplate.find(query, User.class);
    }
}
