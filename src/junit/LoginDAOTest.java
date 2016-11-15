package junit;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Archer on 11/9/16.
 */
public class LoginDAOTest extends TestCase{
    Connection conn;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        conn = DriverManager.getConnection("");
    }

    @After
    public void tearDown() throws Exception{
        super.tearDown();
        conn.close();
    }

    @Test
    public void testSelect() {

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDelete() {

    }

    @Test
    public void testInsert() {

    }
}
