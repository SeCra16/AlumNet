package junit;

import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Archer on 11/9/16.
 */
public class StudentDAOTest extends TestCase {
    Connection conn;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        conn = DriverManager.getConnection("");
    }
}
