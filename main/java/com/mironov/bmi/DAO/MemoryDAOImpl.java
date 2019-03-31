package com.mironov.bmi.DAO;

import com.mironov.bmi.Model.Forum;

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
            bmiList.add(new Forum(bmi,name, weight,height, dateTimeStep));
    }



}
