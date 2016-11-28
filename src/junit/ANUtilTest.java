package junit;

import junit.framework.TestCase;
import org.junit.Test;
import util.ANUtil;

/**
 * Created by Archer on 11/15/16.
 */
public class ANUtilTest extends TestCase {
    ANUtil util = null;
    int i = 0;
    //@Rule public TestName name = new TestName();

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        util = new ANUtil();

        if(i == 0) {
            System.out.print(new Object(){}.getClass().getName() + " results -- ");
            i++;
        }
    }

    @Test
    public void testGetURL() throws Exception {
        assertEquals("jdbc:sqlserver://192.168.133.161:1433;databaseName=AlumNet", util.getURL());
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }

    @Test
    public void testGetUser() throws Exception {
        assertEquals("jarcher", util.getUser().replaceAll(" ", ""));
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }

    @Test
    public void testGetPassword() throws Exception {
        assertEquals("alumnet2", util.getPassword());
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }
}
