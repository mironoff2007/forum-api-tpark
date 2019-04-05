package Service;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.mironov.forum_api.DAO.DAO;
import com.mironov.forum_api.DAO.DAOImpl;
import com.mironov.forum_api.Service.Service;
import com.mironov.forum_api.Service.ServiceImpl;
import org.junit.*;

import java.sql.SQLException;


public class ServiceTest {

    private Injector injector = Guice.createInjector(new AbstractModule() {
        @Override
        protected void configure() {
            bind(Service.class).to(ServiceImpl.class);
            bind(DAO.class).to(DAOImpl.class);
        }
    });

    @Before
    public void setup () {
        injector.injectMembers(this);
    }

    @Inject
    public Service service;


    @Test(expected = IllegalArgumentException.class)
    public void testWrongHeight() throws SQLException {
            service.saveBmi("Vasja",-1,65);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongWeight() throws SQLException {
            service.saveBmi("Vasja",90,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongWeightAndheight() throws SQLException {
            service.saveBmi("Vasja",0,-1);
    }


}