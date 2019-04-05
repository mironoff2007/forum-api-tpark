package com.mironov.forum_api.DAO;

import com.mironov.forum_api.Model.Forum;

import java.sql.SQLException;

public interface DAO {

   public  Forum getForumBySlug(String slug) throws SQLException;
}
