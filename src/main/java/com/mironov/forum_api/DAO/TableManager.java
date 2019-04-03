package com.mironov.forum_api.DAO;

import main.java.com.mironov.forum_api.Util.SQLFileReader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {

    private static final Connection con=ConnectionManager.getConnection();

    private static String crateTable;

    private static String crateDB;

    private static String populate;

    private static String drop="DROP TABLE IF EXISTS forum;";

    public static void createTable() throws SQLException, IOException {
        Statement stmt = con.createStatement();
        // create a new table
        crateTable=new SQLFileReader("src/main/webapp/resources/crate_table.sql").getAsString();

        stmt.execute(crateTable);
    }

    public static void populateTable() throws SQLException, IOException {

        populate=new SQLFileReader("src/main/webapp/resources/populate_table.sql").getAsString();

        Statement stmt = con.createStatement();
        // populate table
        stmt.execute(populate);
    }

    public static void dropTable() throws SQLException {
        Statement stmt = con.createStatement();
        // drop table
        stmt.execute(drop);
    }

    public static void resetTable() throws SQLException, IOException {
        dropTable();
        createTable();
    }

}
