package junit;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.*;

import dao.AlumniDAO;
import dto.AlumniDTO;
import junit.framework.TestCase;

public class AlumniDAOTest extends TestCase {
	Connection conn;
	
	@Override
    protected void setUp() throws Exception
    {
        super.setUp();
        conn = DriverManager.getConnection("");
    }
	
	public void testSelect() {
		AlumniDAO dao = new AlumniDAO(conn);
		
		AlumniDTO dto = new AlumniDTO();
		
		//need test id
		dto.setAlumniID(1);
		
		try {
			dto = (AlumniDTO) dao.select(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Assert.assertNotSame(dto.getFirstName(), "");
	}
	
	public void testUpdate() {
		//Variable to stroe the email
		String originalEmail = null;
		
		AlumniDAO dao = new AlumniDAO(conn);
		
		AlumniDTO dto = new AlumniDTO();
		
		//set the alumni id so we can grab the dto from the database, then update to check
		dto.setAlumniID(1);
		
		try {
		//select the full one
		dto = (AlumniDTO) dao.select(dto);
		
		//Grab the original email and then update the dto and send to update
		originalEmail = dto.getEmail();
		dto.setEmail("testing");
		
		dao.update(dto);
		
		//Grab the select then check to see if it updated
		dto = (AlumniDTO) dao.select(dto);
		} catch (Exception e) {
			
		}
		
		Assert.assertNotSame(dto.getEmail(), originalEmail);
	}
	
	public void testDelete() {
		
	}
	
	public void testInsert() {
		
	}
}
