package com.example.jdbci;

import com.example.jdbci.dao.DAOFactory;
import com.example.jdbci.models.Address;
import com.example.jdbci.models.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        ConnectionFactory.createDropTable();
        doCrudOnUser();
        doCrudOnAddress();
    }
    public static void doCrudOnUser(){
        int id = 1;
        // region INSERT
        DAOFactory.user.insert(new User("james","jamesBond007.msi6.com"));
        DAOFactory.user.insert(new User("tom","tomJedusor@mechants.com"));
        System.out.println(DAOFactory.user.getAll());
        // endregion

        // region UPDATE
        User userToUpdate = new User("bond","bond007@msi.en");
        boolean updated = DAOFactory.user.update(id,userToUpdate);
        System.out.println(updated ? "User updated" : "User not updated");
        System.out.println(DAOFactory.user.getAll());
        // endregion

        // region GETONE
        User u = DAOFactory.user.getOne(id);
        if(u != null){
            System.out.println("user : " + u.getName());
        }
        // endregion

        //region DELETE
        boolean deleted = DAOFactory.user.delete(id);
        System.out.println(deleted ? "User deleted" : "User not deleted");
        System.out.println(DAOFactory.user.getAll());
        // endregion

    }

    public static void doCrudOnAddress(){
        // region INSERT
        int id = 2;
        if(DAOFactory.user.getOne(id) != null){
            DAOFactory.address.insert(new Address("rue a", "ville b",2));
        }
        System.out.println(DAOFactory.address.getAll());
        // endregion

        // region GETONE
        Address address = DAOFactory.address.getOne(1);
        if(address != null){
            System.out.println("Address : " + address.getStreet() + " " + address.getCity());
        }
        // endregion

        // region UPDATE
        if(DAOFactory.user.getOne(id) != null){
            boolean updated = DAOFactory.address.update(1, new Address("rue du bonheur", "ville du paradis",2));
            System.out.println(updated ? "Address updated" : "Address not updated");
        }
        System.out.println(DAOFactory.address.getAll());
        // endregion

        // region DELETE
        boolean deleted = DAOFactory.address.delete(1);
        System.out.println(deleted ? "Address deleted" : "Address not deleted");
        //endregion

        // region GETALL
        System.out.println(DAOFactory.address.getAll());
        // endregion


    }
}