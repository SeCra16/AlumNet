package junit.dao;

import dao.MessageDAO;
import dto.MessageDTO;
import junit.framework.Assert;
import org.junit.*;
import util.ANUtil;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Archer on 11/9/16.
 * Does not need update or delete, since we do not allow message updating/deleting
 */
public class MessageDAOTest {
    Connection conn;
    MessageDAO dao = null;
    MessageDTO dto;
    int i = 0;

    @BeforeClass
    public static void setUpClass() {
//        TODO: SETUP CONNECTIONS AND ADD ENTRIES FOR LOGIN, ALUMNI, STUDENT, CONNECTED
    }

    /**
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception
    {
        ANUtil util = new ANUtil();
        conn = DriverManager.getConnection(util.getURL(),util.getUser(),util.getPassword());

        //set the dao up
        this.dao = new MessageDAO(conn);

        dto = new MessageDTO();

        if(i == 0) {
            System.out.print(new Object(){}.getClass().getName() + " -- ");
            i++;
        }


    }

    /**
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception{
        conn.close();
    }

    /**
     * @throws Exception
     */
    @AfterClass
    public static void tearDownClass() throws Exception {
        ANUtil util = new ANUtil();
        Connection connection = DriverManager.getConnection(util.getURL(),util.getUser(),util.getPassword());

//        TODO: CLEAR OUT THE TABLES WE USED
    }

    /**
     * @throws Exception
     */
    @Test
    public void testInsert() throws Exception {
        dto.setAlumnusEmail("sebas@gmail.com");
        dto.setStudentEmail("jarcher1200@gmail.com");
        dto.setMessage("testing");


        try {
            dao.insert(dto);
        } catch (Exception e) {
            Assert.fail("Reached an error: " + e.getMessage());
        }

        MessageDTO test = dao.select(dto);

        //test all the values
        org.junit.Assert.assertEquals(dto.getMessageID(), test.getMessageID());
        org.junit.Assert.assertEquals(dto.getAlumnusEmail(), test.getAlumnusEmail());
        org.junit.Assert.assertEquals(dto.getStudentEmail(), test.getStudentEmail());
        org.junit.Assert.assertEquals(dto.getMessage(), test.getMessage());


        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass" +
                "\n--------------------------------------------------------------");

    }

    /**
     *
     */
    @Test
    public void testSelect() {
    	
    	//insert should of put data there so we should be good
//        TODO: NEED TO FIX THE CHANGING MESSAGE ID THAT WON'T LET ME PULL
        //need test id
        dto.setAlumnusEmail("sebas@gmail.com");
        dto.setStudentEmail("jarcher1200@gmail.com");
        dto.setMessage("testing");

        try {
            dto = dao.select(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        org.junit.Assert.assertEquals("test", dto.getMessage());
        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass "+
                "\n--------------------------------------------------------------");
    }

    @Test
    public void testSelectAll() {
//        TODO: NEED TO CREATE TEST


        System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + ": pass "+
                "\n--------------------------------------------------------------");
    }
}
