package junit.dao;

import dao.LoginDAO;
import dao.StudentDAO;
import dto.LoginDTO;
import dto.StudentDTO;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;
import util.ANUtil;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Archer on 11/9/16.
 */
public class StudentDAOTest extends TestCase {
    Connection conn;
    StudentDAO dao;
    StudentDTO dto = new StudentDTO();

    @Override
    protected void setUp() throws Exception
    {
        ANUtil util = new ANUtil();
        conn = DriverManager.getConnection(util.getURL(),util.getUser(),util.getPassword());

        dao = new StudentDAO(conn);

        System.out.print(new Object(){}.getClass().getName() + " results -- ");

        dto.setEmail("testStudent@test.com");
        dto.setFirstName("tester");
        dto.setLastName("Student");
        dto.setExpectedGraduation("2017-12-01");
        dto.setMajor("Computer Science");

    }

    @After
    public void tearDown() throws Exception{
        conn.close();
    }

    @Test
    public void testInsert() {
        try {
            //create login so we don't get key error
            LoginDAO loginDAO = new LoginDAO(conn);
            LoginDTO loginDTO = new LoginDTO();

            loginDTO.setEmail(dto.getEmail());
            loginDTO.setPassword("test");
            loginDTO.setType("student");

            loginDAO.insert(loginDTO);

            dao.insert(dto);

            StudentDTO test = (StudentDTO) dao.select(dto);

            assertEquals(dto.getEmail(), test.getEmail());
        } catch (Exception e) {
            fail("Hit error.." + e.getMessage());
        }


        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }

    @Test
    public void testSelect() {
        try {
            dto = (StudentDTO) dao.select(dto);

        } catch (Exception e) {
            fail("hit error when trying select, message: " + e.getMessage());
        }

        System.out.println(dto.getExpectedGraduation());

        assertNotNull(dto);


        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass "+
                "\n--------------------------------------------------------------");
    }

    @Test
    public void testUpdate() {
        String fn = null;

        //get dto values
        try {
            StudentDTO temp = new StudentDTO();
            temp.setEmail("test@test.com");
            dto = (StudentDTO) dao.select(temp);

            //store value to test if we rollback correctly
            fn = dto.getFirstName();
            dto.setFirstName("test");

            dto = (StudentDTO) dao.update(dto);
            dto = (StudentDTO) dao.select(dto);
        } catch (Exception e) {
            fail("Hit error, failing test..." + e.getMessage());
        }

        assertEquals("test", dto.getFirstName());

        //roll back update
        try {
            if (fn != null) {
                dto.setEmail(fn);
                dto = (StudentDTO) dao.update(dto);
            } else {
                throw new Error("Unexpected error occurred");
            }
        } catch (Exception e) {
            System.out.println("Failed to rollback changes... could cause errors.." + e.getMessage());
        }
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }

    @Test
    public void testDelete() {
        //delete the row then re-add with insert test
        try {
            //create a dto to delete
            StudentDTO test = new StudentDTO();
            test.setEmail("test@test.com");

            dao.delete(test);
            test = (StudentDTO) dao.select(test);
            assertNull(test.getEmail());
        } catch (Exception e) {
            fail("Hit error trying to delete..." + e.getMessage());
        }

        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }
}
