package com.rubash.lab13.zad3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {
    String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=lab9java;user=root;password=123";

    public List<Schedule> getScheduleByUserLogin(String userLogin) {
        List<Schedule> schedule = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement statement = connection.prepareStatement("SELECT us.user_id, us.day_of_week, us.start_time, us.end_time, us.description\n" +
                     "FROM user_schedule us\n" +
                     "INNER JOIN users u ON u.id = us.user_id\n" +
                     "WHERE u.username = ?\n")) {
            statement.setString(1, userLogin);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Schedule item = new Schedule(
                        resultSet.getInt("user_id"),
                        resultSet.getInt("day_of_week"),
                        resultSet.getString("start_time"),
                        resultSet.getString("end_time"),
                        resultSet.getString("description")
                );
                schedule.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedule;
    }


    public List<Schedule> getUserSchedule(int user_id) {
        List<Schedule> schedule = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM user_schedule WHERE user_id=?")) {
            statement.setInt(1, user_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Schedule item = new Schedule(
                        resultSet.getInt("user_id"),
                        resultSet.getInt("day_of_week"),
                        resultSet.getString("start_time"),
                        resultSet.getString("end_time"),
                        resultSet.getString("description")
                );
                schedule.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedule;
    }
    public List<Schedule> getAllSchedules() {
        List<Schedule> scheduleList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement statement = connection.prepareStatement("SELECT us.user_id, us.day_of_week, us.start_time, us.end_time, us.description\n" +
                     "FROM user_schedule us\n")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Schedule item = new Schedule(
                        resultSet.getInt("user_id"),
                        resultSet.getInt("day_of_week"),
                        resultSet.getString("start_time"),
                        resultSet.getString("end_time"),
                        resultSet.getString("description")
                );
                scheduleList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scheduleList;
    }



    public boolean updateSchedule(List<Schedule> schedule) {
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE user_schedule SET description=? WHERE id=?")) {
            for (Schedule item : schedule) {
                statement.setString(1, item.getDescription());
                statement.setInt(2, item.getId());
                statement.addBatch();
            }
            int[] rowsUpdated = statement.executeBatch();
            for (int row : rowsUpdated) {
                if (row == 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public void saveSchedule(List<Schedule> schedules) {
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM user_schedule WHERE user_id = ?");
             PreparedStatement insertStatement = connection.prepareStatement(
                     "INSERT INTO user_schedule (user_id, day_of_week, start_time, end_time, description) " +
                             "VALUES (?, ?, ?, ?, ?)")) {
            // Удаляем все записи из таблицы user_schedule для данного пользователя
            statement.setInt(1, schedules.get(0).getuser_id());
            statement.executeUpdate();

            // Добавляем новое расписание
            for (Schedule schedule : schedules) {
                insertStatement.setInt(1, schedule.getuser_id());
                insertStatement.setInt(2, schedule.getday_of_week());
                insertStatement.setTime(3, Time.valueOf(schedule.getstart_time()));
                insertStatement.setTime(4, Time.valueOf(schedule.getend_time()));
                insertStatement.setString(5, schedule.getDescription());
                insertStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
