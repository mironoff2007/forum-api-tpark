package com.mironov.forum_api.DAO;

import com.mironov.forum_api.Util.SQLFileReader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {

    public static TableManager tb=new TableManager();

    private static final Connection con=ConnectionManager.getConnection();

    private static String crateTable;

    private static String crateDB;

    private static String populate;

    private static String drop="DROP TABLE IF EXISTS forum;";

    public static void createTable(String path) throws SQLException, IOException {
        Statement stmt = con.createStatement();
        // create a new table
        crateTable=new SQLFileReader(path).getAsString();

        stmt.execute(crateTable);
    }

    public static void populateTable(String path) throws SQLException, IOException {

        populate=new SQLFileReader(path).getAsString();

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
        createTable("");
    }

}
