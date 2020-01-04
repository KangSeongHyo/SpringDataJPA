package com.study.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Application {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/springdata";
        String username = "ksh";
        String pw = "pw";

        try (Connection connection = DriverManager.getConnection(url,username,pw)){
            System.out.println("Connection 연결 : "+ connection);
            String sql = "CREATE TABLE STUDY(ID INT, NAME VARCHAR(255), AGE INT)";
            Statement st = connection.createStatement();
            st.execute(sql);
        }catch (Exception e){
        }
    }
}
