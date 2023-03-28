package com.example.configure.Repository;

import com.example.configure.Dtos.UserDetailsRequestDTO;
import com.example.configure.Model.PersistInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PersistInfoStoreRepo implements IPersistInfoStoreRepo{

    private final MongoTemplate getMongoTemplate;

    @Autowired
    public PersistInfoStoreRepo(MongoTemplate mongoTemplate) {
        this.getMongoTemplate = mongoTemplate;
    }

    @Override
    public void addOne(PersistInfo requestDTOList) {
        getMongoTemplate.save(requestDTOList);
    }

    @Override
    public List<PersistInfo> getAll(){
        return getMongoTemplate.findAll(PersistInfo.class);
    }

    @Override
    public List<PersistInfo> getByName(List<String> names){
        Query query = new Query();
        Criteria criteria = Criteria.where("fName").in(names);
        query.addCriteria(criteria);
        return getMongoTemplate.find(query, PersistInfo.class);
    }
}
