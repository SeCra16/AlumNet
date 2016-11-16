package junit;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import util.ANUtil;

import java.sql.DriverManager;

/**
 * Created by Archer on 11/15/16.
 */
public class ANUtilTest extends TestCase {
    ANUtil util = null;
    //@Rule public TestName name = new TestName();

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        util = new ANUtil();
    }

    @Test
    public void testGetURL() throws Exception {
        assertEquals("jdbc:sqlserver://192.168.133.147:1433;databaseName=AlumNet", util.getURL());
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass");
    }

    @Test
    public void testGetUser() throws Exception {
        assertEquals("jarcher", util.getUser());
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass");
    }

    @Test
    public void testGetPassword() throws Exception {
        assertEquals("alumnet2", util.getPassword());
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass");
    }
}
