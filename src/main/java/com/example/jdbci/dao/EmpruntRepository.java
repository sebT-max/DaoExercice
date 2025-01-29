package com.example.jdbci.dao;

import com.example.jdbci.models.Address;
import com.example.jdbci.models.Emprunt;

import java.util.List;

public interface EmpruntRepository {
    List<Emprunt> getAll();
    Emprunt getOne(int id);
    boolean insert(Emprunt emprunt);
    boolean update(int id, Emprunt emprunt);
    boolean delete(int id);
}
