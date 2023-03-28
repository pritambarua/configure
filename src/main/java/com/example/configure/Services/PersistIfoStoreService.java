package com.example.configure.Services;


import com.example.configure.Dtos.UserDetailsRequestDTO;
import com.example.configure.Model.PersistInfo;
import com.example.configure.Repository.IPersistInfoStoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersistIfoStoreService {
    private final IPersistInfoStoreRepo persistInfoStoreRepo;

    @Autowired
    public PersistIfoStoreService(IPersistInfoStoreRepo persistInfoStoreRepo) {
        this.persistInfoStoreRepo = persistInfoStoreRepo;
    }

    public void addOne(PersistInfo requestDTOList){
         persistInfoStoreRepo.addOne(requestDTOList);
    };

    public List<PersistInfo> getAll(){
        return persistInfoStoreRepo.getAll();
    };

    public List<PersistInfo> getByName(List<String> names){
        return persistInfoStoreRepo.getByName(names);
    };
}
