package com.favtuts.jdbc.preparestatement.row;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RowDelete {

    private static final String SQL_DELETE = "DELETE FROM EMPLOYEE WHERE NAME=?";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl", "system", "Password123");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_DELETE)) {

            preparedStatement.setString(1, "favtuts");

            int row = preparedStatement.executeUpdate();

            // rows affected
            System.out.println(row);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
