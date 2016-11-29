package persistence;

import java.sql.SQLException;

import org.apache.struts2.dispatcher.SessionMap;

import dao.LoginDAO;
import dto.AlumniDTO;
import dto.LoginDTO;
import dto.StudentDTO;
import dto.UserDTO;

public class LoginPersistence extends AlumNetPersistence{
	private LoginDAO dao;
	private String type;
	
	//default constructor
	public LoginPersistence() {
		
	}
	
	public void addLogin(LoginDTO dto) throws SQLException, Exception {
		//connect to the database
		connect();
		
		//create dao with connection
		dao = new LoginDAO(getConnection());
		
		//insert the dto into database
		dao.insert(dto);

		close();
	}
	
	public UserDTO login(LoginDTO dto, String type) throws SQLException, Exception {
		//connect to database
		connect();
		
		//create dao with connection
		dao = new LoginDAO(getConnection());
		UserDTO sdto = null;
		if (type != null) {
			if (type.toLowerCase().equals("student")) {
				sdto = (StudentDTO) dao.select(dto, type.toLowerCase());
			} else if (type.toLowerCase().equals(("alumnus"))) {
				sdto = (AlumniDTO) dao.select(dto, type.toLowerCase());
			}
		} else {
			throw new Exception("No type selected");
		}
		
		close();
		return sdto;
	}
}
