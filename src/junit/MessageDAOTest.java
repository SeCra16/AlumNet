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
    public void testInsert() throws Exception {
        MessageDTO dto = new MessageDTO();

        dto.setAlumnusEmail("sebas@gmail.com");
        dto.setStudentEmail("jarcher1200@gmail.com");
        dto.setMessage("test");


        try {
            dao.insert(dto);
        } catch (Exception e) {
            Assert.fail("Reached an error: " + e.getMessage());
        }

        MessageDTO test = dao.select(dto);

        //test all the values
        assertEquals(dto.getMessageID(), test.getMessageID());
        assertEquals(dto.getAlumnusEmail(), test.getAlumnusEmail());
        assertEquals(dto.getStudentEmail(), test.getStudentEmail());
        assertEquals(dto.getMessage(), test.getMessage());


        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");

    }
    
    @Test
    public void testSelect() {
    	
    	//insert should of put data there so we should be good

        MessageDTO dto = new MessageDTO();

        //need test id
        dto.setAlumnusEmail("sebas@gmail.com");
        dto.setStudentEmail("jarcher1200@gmail.com");
        dto.setMessage("test");

        try {
            dto = dao.select(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals("test", dto.getMessage());
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass "+
                "\n--------------------------------------------------------------");
    }
}
