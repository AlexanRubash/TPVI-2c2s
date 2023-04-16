package com.example.lab9.zad3;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class UserDAO {
    String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=lab9java;user=root;password=123";


    public User getUserByLogin(String login) {
        User user = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username=?")) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public boolean addUser(User user) {
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, password, role) VALUES (?, ?, ?)")) {
            statement.setString(1, user.getLogin());
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            statement.setString(2, hashedPassword);
            statement.setString(3, user.getRole());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkUserExists(String login) {
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM users WHERE username=?")) {
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }

         catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return false;
    }
    public User getUserById(int id) {
        User user = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id=?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }



    public boolean checkPassword(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}