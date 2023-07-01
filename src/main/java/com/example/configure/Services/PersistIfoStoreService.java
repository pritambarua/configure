package com.example.configure.Services;


import com.example.configure.Model.PersistInfo;
import com.example.configure.Repository.IPersistInfoStoreRepo;
import com.example.configure.Repository.PersistInfoStoreRepo;
import com.example.configure.search.PersistInfoSearchRepoImpl;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class PersistIfoStoreService {
    private final IPersistInfoStoreRepo persistInfoStoreRepo;
    private final PersistInfoSearchRepoImpl persistInfoSearchRepo;

    public PersistIfoStoreService(
            IPersistInfoStoreRepo persistInfoStoreRepo,
            PersistInfoSearchRepoImpl persistInfoSearchRepo
    ) {
        this.persistInfoStoreRepo = persistInfoStoreRepo;
        this.persistInfoSearchRepo = persistInfoSearchRepo;
    }

    public void addOne(PersistInfo requestDTOList) throws IOException {
         persistInfoStoreRepo.addOne(requestDTOList);
         persistInfoSearchRepo.saveAll(Collections.singletonList(requestDTOList));
    };

    public List<PersistInfo> getAll(){
        return persistInfoStoreRepo.getAll();
    };

    public List<PersistInfo> getByName(List<String> names){
        return persistInfoStoreRepo.getByName(names);
    };
}
