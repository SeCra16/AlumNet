package junit;

import dao.AlumniDAO;
import dto.AlumniDTO;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;
import util.ANUtil;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Archer on 11/9/16.
 */
public class AlumniDAOTest extends TestCase {

    Connection conn;
    int i = 0;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        ANUtil util = new ANUtil();
        conn = DriverManager.getConnection(util.getURL(),util.getUser(),util.getPassword());

            System.out.print(new Object(){}.getClass().getName() + " results -- ");
    }

    @After
    public void tearDown() throws Exception{
        super.tearDown();
        conn.close();
    }

    @Test
    public void testSelect() throws Exception {
        AlumniDAO dao = new AlumniDAO(conn);
        AlumniDTO dto = new AlumniDTO();
        dto.setAlumniID(999);

        dto = (AlumniDTO) dao.select(dto);

        assertNotNull(dto.getActive());

        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }

    @Test
    public void testUpdate() throws Exception {
        AlumniDAO dao = new AlumniDAO(conn);
        AlumniDTO dto = new AlumniDTO();

        dto.setAlumniID(0);
        dto = (AlumniDTO) dao.select(dto);

        AlumniDTO tDto = new AlumniDTO(dto);

        //store email so we can revert for testing cleanleness
        String temp = tDto.getEmail();

        //set the test email
        tDto.setEmail("test");

        dto = (AlumniDTO) dao.update(tDto);

        //check it
        assertEquals(tDto.getEmail(), dto.getEmail());


        dto.setEmail(temp);
        dao.update(dto);


        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }

    @Test
    public void testDelete() throws Exception {
        AlumniDAO dao = new AlumniDAO(conn);
        AlumniDTO dto = new AlumniDTO();
        dto.setAlumniID(999);

        dao.delete(dto);

        dto = (AlumniDTO) dao.select(dto);

        assertNull(dto.getEmail());

        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }

    @Test
    public void testInsert() throws Exception {
        AlumniDAO dao = new AlumniDAO(conn);
        AlumniDTO dto = new AlumniDTO();
        dto.setAlumniID(999);
        dto.setFirstName("Josh");
        dto.setLastName("Archer");
        dto.setEmail("jarcher1200@gmail.com");
        dto.setJobField("Computer Science");
        dto.setGraduationDate(new java.sql.Date(new java.util.Date().getTime()));

        dao.insert(dto);
        dto = (AlumniDTO) dao.select(dto);

        assertNotNull(dto.getEmail());


        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }

}
