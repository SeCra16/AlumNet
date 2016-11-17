package junit;

import dao.MessageDAO;
import dto.MessageDTO;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;
import util.ANUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Random;

/**
 * Created by Archer on 11/9/16.
 * Does not need update or delete, since we do not allow message updating/deleting
 */
public class MessageDAOTest extends TestCase {
    Connection conn;
    MessageDAO dao = null;
    int i = 0;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        ANUtil util = new ANUtil();
        conn = DriverManager.getConnection(util.getURL(),util.getUser(),util.getPassword());

        //set the dao up
        this.dao = new MessageDAO(conn);

        if(i == 0) {
            System.out.print(new Object(){}.getClass().getName() + " -- ");
            i++;
        }
    }

    @After
    public void tearDown() throws Exception{
        super.tearDown();
        conn.close();
    }

    @Test
    public void testSelect() {

        MessageDTO dto = new MessageDTO();

        //need test id
        dto.setConnectionID(0);
        dto.setMessageID(0);

        try {
            dto = dao.select(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals("test", dto.getMessage());
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass "+
                "\n--------------------------------------------------------------");
    }

    @Test
    public void testInsert() throws Exception {
        MessageDTO dto = new MessageDTO();

        Random r = new Random();
        dto.setMessageID(r.nextInt(10000));
        dto.setConnectionID(0);
        dto.setMessage("test");


        try {
            dao.insert(dto);
        } catch (Exception e) {
            Assert.fail("Reached an error: " + e.getMessage());
        }

        MessageDTO test = dao.select(dto);

        Assert.assertEquals(dto.getConnectionID(), test.getConnectionID());
        Assert.assertEquals(dto.getMessageID(), test.getMessageID());
        Assert.assertEquals(dto.getMessage(), test.getMessage());


        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");

    }
}
