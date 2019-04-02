package com.mironov.bmi.DAO;

import com.mironov.bmi.Util.SQLFileReader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {

    private static final Connection con=ConnectionManager.getConnection();

    private static String crateTable;

    private static String crateDB;

    private static String populate=
            "INSERT INTO \"bmi\" VALUES \n" +
                    "\t(2.0515087,'Vasja',65,178,1553518802929),\n" +
                    "\t(2.3529413,'Petja',68,170,1553518802960);";

    private static String drop="DROP TABLE IF EXISTS bmi;";

    public static void createTable() throws SQLException {
        Statement stmt = con.createStatement();
        // create a new table
        try {
            crateTable=new SQLFileReader("main/webapp/resources/crate_table.sql").getAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stmt.execute(crateTable);
    }

    public static void populateTable() throws SQLException {
        Statement stmt = con.createStatement();
        // populate table
        stmt.execute(populate);
    }

    public static void dropTable() throws SQLException {
        Statement stmt = con.createStatement();
        // drop table
        stmt.execute(drop);
    }

    public static void resetTable() throws SQLException {
        dropTable();
        createTable();
    }

}
