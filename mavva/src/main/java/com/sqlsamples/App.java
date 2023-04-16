package com.sqlsamples;

import connector.Mssql;
import org.apache.log4j.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        try {
            String log4jConfPath = "C:\\Users\\rubas\\Desktop\\Универ\\2-2\\Java\\mavva\\src\\main\\java\\resourses\\log4j.properties";
            PropertyConfigurator.configure(log4jConfPath);
                Mssql mssql=new Mssql();
                mssql.printResult();
        } catch (Exception e) {
            System.out.println("");
            e.printStackTrace();
        }
    }
}