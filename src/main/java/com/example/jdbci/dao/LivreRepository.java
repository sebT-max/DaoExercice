package com.example.jdbci.dao;

import com.example.jdbci.models.Address;
import com.example.jdbci.models.Livre;

import java.util.List;

public interface LivreRepository {
    List<Livre> getAll();
    Livre getOne(int id);
    boolean insert(Livre livre);
    boolean update(int id, Livre livre);
    boolean delete(int id);
}
