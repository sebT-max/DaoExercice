package com.example.jdbci.dao;

import com.example.jdbci.ConnectionFactory;
import com.example.jdbci.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserRepository{
    @Override
    public List<User> getAll() {
        // SELECT * FROM user
        List<User> users = new ArrayList<User>();
        try(
                Connection connection = ConnectionFactory.connection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM \"user\"")
                )
        {
            while(rs.next()){
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                ));
            }
            return users;
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public User getOne(int id) {
        // SELECT * FROM user WHERE id= id
        try(
                Connection connection = ConnectionFactory.connection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"user\" WHERE id = ?");
                )
        {
            statement.setInt(1,id);
            try( ResultSet rs = statement.executeQuery()){
                if(rs.next()){
                    return new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email")
                    );
                }
                System.out.println("Exception : User not found");
                return null;
            }
            }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean insert(User user) {
        // INSERT INTO user (name,email) VALUES (?,?)
        try(
                Connection connection = ConnectionFactory.connection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO \"user\" (name,email) VALUES (?,?)")
                )
        {
            statement.setString(1, user.getName());
            statement.setString(2,user.getEmail());
            return statement.executeUpdate() > 0;
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean update(int id, User user) {
        // UPDATE user SET = name = ?, email = ? WHERE id = ?
        try(
                Connection connection = ConnectionFactory.connection();
                PreparedStatement statement = connection.prepareStatement("UPDATE \"user\" SET name = ?, email = ? WHERE id = ?")
                )
        {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(3,id);
            return statement.executeUpdate() > 0;
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean delete(int id) {
        // DELETE FROM user WHERE id = ?
        try(
                Connection connection = ConnectionFactory.connection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM \"user\" WHERE id = ?")
                )
        {
            statement.setInt(1,id);
            return statement.executeUpdate() > 0;
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
