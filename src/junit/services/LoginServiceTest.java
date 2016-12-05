package junit.services;

import dao.LoginDAO;
import dto.LoginDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.ANUtil;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Archer on 11/15/16.
 */
public class LoginServiceTest {
    Connection conn;
    LoginDAO dao;
    LoginDTO dto;
    int i = 0;

    @Before
    public void setUp() throws Exception {
        ANUtil util = new ANUtil();
        conn = DriverManager.getConnection(util.getURL(),util.getUser(),util.getPassword());

        //set the dao up
        this.dao = new LoginDAO(conn);

        dto = new LoginDTO();

        if(i == 0) {
            System.out.print(new Object(){}.getClass().getName() + " -- ");
            i++;
        }
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void testValidateUser() throws Exception {

    }

    @Test
    public void testCreateLogin() throws Exception {

    }

    @Test
    public void testCreateLogin1() throws Exception {

    }

    @Test
    public void testDeleteLogin() throws Exception {

    }

}
