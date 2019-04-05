package DAO;


import com.mironov.forum_api.DAO.TableManager;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.sql.SQLException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TableManagerTest {
    @Test
    public void testADropTable() throws SQLException {
        TableManager.dropTable();
    }
    @Test
    public void testBCreateTable() throws SQLException, IOException {
        TableManager.createTable("src\\main\\webapp\\WEB-INF\\resources\\crate_table.sql");
    }

    @Test
    public void testCPopulateTable() throws SQLException, IOException {
        TableManager.populateTable("populate_table.sql");
        TableManager.resetTable();
    }
}
