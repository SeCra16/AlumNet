package junit.dao;

import dao.AlumniDAO;
import dao.LoginDAO;
import dto.AlumniDTO;
import dto.LoginDTO;
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
    AlumniDAO dao;
    AlumniDTO dto;
    int i = 0;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        ANUtil util = new ANUtil();
        conn = DriverManager.getConnection(util.getURL(),util.getUser(),util.getPassword());

        dao = new AlumniDAO(conn);
        dto = new AlumniDTO();

        dto.setEmail("testAlumni@test.com");
        dto.setFirstName("test");
        dto.setLastName("Alumnus");
        dto.setJobField("Computer Science");
        dto.setGraduationDate(new java.sql.Date(new java.util.Date().getTime()));

        System.out.print(new Object(){}.getClass().getName() + " results -- ");
    }

    @After
    public void tearDown() throws Exception{
        super.tearDown();
        conn.close();
    }

    @Test
    public void testInsert() throws Exception {
        //set the login so that we can add again
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail(dto.getEmail());
        loginDTO.setPassword("test");
        loginDTO.setType("alumnus");

        LoginDAO loginDAO = new LoginDAO(conn);
        loginDAO.insert(loginDTO);


        dao.insert(dto);
        dto = (AlumniDTO) dao.select(dto);

        assertNotNull(dto.getEmail());


        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }

    @Test
    public void testSelect() throws Exception {

        dto = (AlumniDTO) dao.select(dto);

        assertNotNull(dto.getActive());

        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }

    @Test
    public void testUpdate() throws Exception {
        //need to update the login first
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("123@gmail.com");
        loginDTO.setPassword("test");
        loginDTO.setType("alumnus");

        LoginDAO loginDAO = new LoginDAO(conn);
        loginDAO.update(loginDTO);

        dto = (AlumniDTO) dao.select(dto);

        AlumniDTO tDto = new AlumniDTO(dto);

        //store email so we can revert for testing cleanliness
        String temp = tDto.getEmail();

        //set the test email
        tDto.setEmail("123@gmail.com");

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
        dao.delete(dto);

        dto = (AlumniDTO) dao.select(dto);

        assertNull(dto.getEmail());

        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");
    }


}