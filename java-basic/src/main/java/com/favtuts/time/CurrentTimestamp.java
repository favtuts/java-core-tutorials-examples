package com.favtuts.time;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class CurrentTimestamp {

    // 2021.03.24.16.34.26
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    // 2021-03-24T16:44:39.083+08:00
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    // 2021-03-24 16:48:05
    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

    public static void main(String[] args) {
        // currentTimestampWithJavaSqlTimestamp();
        convertInstantToFromTimestamp();
    }

    static void insertTimestampIntoTable() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/test", "postgres", "password");
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.setString(1, "favtuts");
            preparedStatement.setBigDecimal(2, new BigDecimal("799.88"));
            preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            // preparedStatement.setTimestamp(3,
            // Timestamp.from(ZonedDateTime.now().toInstant()));
            // preparedStatement.setTimestamp(3, Timestamp.from(Instant.now()));

            int row = preparedStatement.executeUpdate();

            // rows affected
            System.out.println(row); // 1

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void convertInstantToFromTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp); // 2021-03-24 17:12:03.311
        System.out.println(timestamp.getTime()); // 1616577123311

        // Convert Timestamp to Instant
        Instant instant = timestamp.toInstant();
        System.out.println(instant); // 2021-03-24T09:12:03.311Z
        System.out.println(instant.toEpochMilli()); // 1616577123311

        // Convert Instant to Timestamp
        Timestamp tsFromInstant = Timestamp.from(instant);
        System.out.println(tsFromInstant.getTime()); // 1616577123311
    }

    static void currentTimestampWithJavaSqlTimestamp() {

        // method 1
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp); // 2021-03-24 16:34:26.666

        // method 2 - via Date
        Date date = new Date();
        System.out.println(new Timestamp(date.getTime())); // 2021-03-24 16:34:26.666
                                                           // number of milliseconds since January 1, 1970, 00:00:00 GMT
        System.out.println(timestamp.getTime()); // 1616574866666

        System.out.println(sdf1.format(timestamp)); // 2021.03.24.16.34.26

        System.out.println(sdf2.format(timestamp)); // 2021-03-24T16:48:05.591+08:00

        System.out.println(sdf3.format(timestamp)); // 2021-03-24 16:48:05

    }
}
