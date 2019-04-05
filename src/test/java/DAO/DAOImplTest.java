package DAO;


import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import com.mironov.forum_api.DAO.DAO;
import com.mironov.forum_api.DAO.DAOImpl;
import com.mironov.forum_api.DAO.TableManager;
import com.mironov.forum_api.Model.Forum;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import java.sql.SQLException;

public class DAOImplTest {

    private Injector injector = Guice.createInjector(new AbstractModule() {
        @Override
        protected void configure() {
            bind(DAO.class).to(DAOImpl.class);
        }
    });

    @Inject
    public DAO dao;

    @Before
    public void setup() {
        injector.injectMembers(this);
    }

    @Test
    public void testGetBmiList() throws SQLException, IOException {
        TableManager.resetTable();
        TableManager.populateTable("");
        System.out.println(dao.getForumBySlug("slug1").toString());
        TableManager.resetTable();
    }

}