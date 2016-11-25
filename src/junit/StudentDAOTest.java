package junit;

import dao.StudentDAO;
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

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        ANUtil util = new ANUtil();
        conn = DriverManager.getConnection(util.getURL(),util.getUser(),util.getPassword());

        dao = new StudentDAO(conn);

        System.out.print(new Object(){}.getClass().getName() + " results -- ");
    }

    @After
    public void tearDown() throws Exception{
        super.tearDown();
        conn.close();
    }

    @Test
    public void testSelect() {
        StudentDTO dto = new StudentDTO();

        dto.setStudentID(0);
        dto.setFirstName("Josh");
        dto.setLastName("Archer");
        dto.setEmail("jarcher1200@gmail.com");

        try {
            dto = (StudentDTO) dao.select(dto);

        } catch (Exception e) {
            fail("hit error when trying select, message: " + e.getMessage());
        }

        System.out.println(dto.getExpectedGraduation());

        assertEquals(0, dto.getStudentID());


        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass "+
                "\n--------------------------------------------------------------");
    }

    @Test
    public void testUpdate() {
        StudentDTO dto = new StudentDTO();




        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }

    @Test
    public void testDelete() {
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }

    @Test
    public void testInsert() {
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }

}
