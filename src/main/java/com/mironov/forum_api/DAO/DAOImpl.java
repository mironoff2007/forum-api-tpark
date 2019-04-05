package com.mironov.forum_api.DAO;

import com.mironov.forum_api.Model.Forum;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DAOImpl implements DAO {

    private final Connection connection = ConnectionManager.getConnection();


    @Override
    public Forum getForumBySlug(String slug) throws SQLException {
        Forum forum = null;

        Statement stmt = null;

        String query = "select * from forum f Where f.slug="+"'"+slug+"'";
        System.out.println(query);
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            //

            rs.next();

            int posts = rs.getInt("posts");

            int threads = rs.getInt("threads");

            String title = rs.getString("title");

            String user = rs.getString("user");

            forum = new Forum(posts, threads, slug, title, user);

        } catch (SQLException e) {
            throw new SQLException("can't find forum");
        }

        return forum;
    }
}