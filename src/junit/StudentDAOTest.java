package junit;

import junit.framework.TestCase;
import org.junit.Test;

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
