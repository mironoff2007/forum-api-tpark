package com.mironov.bmi.DAO;

import com.mironov.bmi.Model.Forum;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DAOImpl implements DAO {

    private final Connection connection=ConnectionManager.getConnection();

    @Override
    public List<Forum> getBmiList() throws SQLException {
        ArrayList<Forum> bmiList = new ArrayList<>();
        Statement stmt = null;
        String query = "select *from bmi";
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                float bmi = rs.getFloat("bmi");

                String name = rs.getString("name");

                int height=rs.getInt("height");

                int weight=rs.getInt("weight");

                long dateTimeStep=rs.getLong("dateTimeStep");
                /*
                System.out.println("{bmi=" + bmi +
                        ", name='" + name + '\'' +
                        ", weight=" + weight +
                        ", height=" + height +
                        ", dateTimeStep=" + dateTimeStep +
                        '}');
                        */

                bmiList.add(new Forum(bmi , name ,weight , height , dateTimeStep ));
            }
        } catch (SQLException e ) {
            throw e;
        } finally {
            if (stmt != null) { stmt.close(); }
        }
        return bmiList;
    }

    @Override
    public void addBmiRecord( float bmi, String name, int weight, int height, long dateTimeStep) throws SQLException {
        Statement stmt = null;
        String query = "INSERT INTO \"bmi\" VALUES \n" +
                "("+bmi+",'"+name+"',"+weight+","+height+","+dateTimeStep+");";
        System.out.println(query);
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e ) {
            throw e;
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }
}
