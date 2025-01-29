package com.example.jdbci;

import com.example.jdbci.models.Address;
import com.example.jdbci.models.User;
import com.example.jdbci.models.Emprunt;
import com.example.jdbci.models.Livre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/technofuturtic_firstdb";
    private static final String USER = "sebt-max";
    private static final String PASSWORD = "";

    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public static void createDropTable(){
        try(
                Connection connection = connection();
                Statement statement = connection.createStatement();
                )
        {
            // drop les tables si jamais elles existent
            statement.execute("DROP TABLE IF EXISTS address CASCADE");
            statement.execute("DROP TABLE IF EXISTS \"user\" CASCADE");
            System.out.println("Table address et user vidées avec succès");

            // création des tables
            statement.executeUpdate(User.queryCreateTable());
            statement.executeUpdate(Address.queryCreateTable());
            statement.executeUpdate(Emprunt.queryCreateTable());
            statement.executeUpdate(Livre.queryCreateTable());

            System.out.println("Tables créées avec succès");

        }catch(SQLException error){
            System.out.println(error.getMessage());
        }
    }
}
