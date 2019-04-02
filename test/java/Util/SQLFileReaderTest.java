package Util;

import com.mironov.bmi.Util.SQLFileReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class SQLFileReaderTest  {



    @Before
    public void setup () {
    }



    @Test
    public void testGetAsString() throws IOException {
        SQLFileReader reader = new SQLFileReader("main/webapp/resources/test.sql");
        String expectedString="DROP TABLE IF EXISTS forum;\n" +
                "CREATE TABLE \"forum\"\n";
        String result=reader.getAsString();
        assertEquals(true, expectedString.equals(result));
    }




}