package com.example.jdbci.dao;

import com.example.jdbci.models.Address;

import java.util.List;

public interface AddressRepository {
    List<Address> getAll();
    Address getOne(int id);
    boolean insert(Address address);
    boolean update(int id, Address address);
    boolean delete(int id);
}
