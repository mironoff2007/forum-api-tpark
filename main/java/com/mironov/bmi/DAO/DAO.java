package com.mironov.bmi.DAO;

import com.mironov.bmi.Model.Forum;

import java.sql.SQLException;
import java.util.List;


public interface DAO {

     List<Forum> getBmiList() throws SQLException;

     void addBmiRecord(float bmi, String name, int weight, int height,long dateTimeStep) throws SQLException;
}
