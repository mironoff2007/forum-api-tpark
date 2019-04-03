package com.mironov.forum_api.Service;

import com.mironov.forum_api.Model.Forum;


import java.sql.SQLException;
import java.util.List;


public interface Service {
     List<Forum> getBmiList();

     void saveBmi(String name, int height, int weight) throws IllegalArgumentException, SQLException;
}