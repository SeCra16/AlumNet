package junit;

import junit.framework.TestCase;
import org.junit.After;
import util.ANUtil;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Archer on 11/9/16.
 */
public class AlumniDAOTest extends TestCase {

    Connection conn;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        ANUtil util = new ANUtil();
        conn = DriverManager.getConnection(util.getURL(),util.getUser(),util.getPassword());
    }

    @After
    public void tearDown() throws Exception{
        super.tearDown();
        conn.close();
    }
}
