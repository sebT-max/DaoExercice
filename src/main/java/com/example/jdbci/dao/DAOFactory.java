package com.example.jdbci.dao;

public interface DAOFactory {
    UserRepository user = new UserDAO();
    AddressRepository address = new AddressDAO();
}
