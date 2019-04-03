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
        TableManager.populateTable();
        System.out.println(dao.getBmiList().toString());
        TableManager.resetTable();
    }

    @Test
    public void testAddBmi() throws SQLException, IOException {
        TableManager.resetTable();
        dao.addBmiRecord(2,"test1",60, 160,1553518802960L);
        ArrayList<Forum> list=new ArrayList<Forum>();
        //list.add(new Forum(2,"test1",60, 160,1553518802960L));
        System.out.println(dao.getBmiList().toString());
        System.out.println(list.toString());
        assertEquals(true,(list.toString().equals(dao.getBmiList().toString())));
        TableManager.resetTable();
    }
}
