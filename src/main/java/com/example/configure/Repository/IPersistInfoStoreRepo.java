package com.example.configure.Repository;

import com.example.configure.Dtos.UserDetailsRequestDTO;
import com.example.configure.Model.PersistInfo;

import java.util.List;

public interface IPersistInfoStoreRepo {
    public void addOne(PersistInfo requestDTOList);

    public List<PersistInfo> getAll();

    public List<PersistInfo> getByName(List<String> names);
}
