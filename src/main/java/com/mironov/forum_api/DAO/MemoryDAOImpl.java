package com.mironov.forum_api.DAO;

import com.mironov.forum_api.Model.Forum;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class MemoryDAOImpl implements DAO {


    private final List<Forum> bmiList;

    public MemoryDAOImpl() {
        bmiList = new CopyOnWriteArrayList<>();
    }

    public List<Forum> getBmiList() {
        return bmiList;
    }

    public void addBmiRecord(float bmi,String name, int weight, int height,long dateTimeStep){

    }



}
