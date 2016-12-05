package junit.dao;

import dao.LoginDAO;
import dto.LoginDTO;
import dto.UserDTO;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;
import util.ANUtil;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Archer on 11/9/16.
 */
public class LoginDAOTest extends TestCase {
    Connection conn;
    int i = 0;
    LoginDAO dao = null;
    LoginDTO dto;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        ANUtil util = new ANUtil();
        conn = DriverManager.getConnection(util.getURL(),util.getUser(),util.getPassword());

        System.out.print(new Object(){}.getClass().getName() + " results -- ");

        dao = new LoginDAO(conn);

        dto = new LoginDTO();

        dto.setEmail("jarcher1200@gmail.com");
        dto.setPassword("password");
    }

    @After
    public void tearDown() throws Exception{
        super.tearDown();
        conn.close();
    }

    @Test
    public void testSelect() {
        UserDTO tDto = null;
        String type = null;


        try {
            //returns a UserDTO object if the signin worked
            type = dao.select(dto);
        } catch (Exception e) {
            fail("Hit error with select " + e.getMessage());
        }

        assertNotNull(type);

        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }

    @Test
    public void testUpdate() {
        UserDTO tDto = null;
        String type = null;

        try {
            //capitalize password as the update
            dto.setPassword("Password");
            dao.update(dto);

            //now see if the update worked
            type = dao.select(dto);
        } catch (Exception e) {
            fail("Hit error with update " + e.getMessage());
        }


        assertNotNull(type);

        try {
            //revert the test
            dto.setPassword("password");
            dao.update(dto);
        } catch (Exception e) {
            System.out.println("** WARNING: FAILED TO REVERT TEST DATA BACK... PLEASE RUN THE FOLLOWING SQL QUERY:\n +" +
                    "UPDATE AlumNet.dbo.Login set Password='password' where ID=0");
        }
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }


    @Test
    public void testDelete() throws Exception {
        //delete data
        UserDTO tDto = null;
        String type = null;

        try {
            dao.delete(dto);

            //see if select returns anything
            type = dao.select(dto);
            assertNull(type);
        } catch (Exception e) {
            System.out.println("Error running testDelete(): " + e.getMessage());
        }

    }

    @Test
    public void testInsert() {
        //insert should set back up environment
        UserDTO tDto = null;
        String type = null;

        try {
            dao.insert(dto);

            type = dao.select(dto);
            assertNotNull(type);
        } catch (Exception e) {
            System.out.println("Error running testInsert(): " + e.getMessage());
        }

    }
}
