package Persistence;

import java.sql.SQLException;

import DAO.LoginDAO;
import DTO.AlumniDTO;
import DTO.LoginDTO;
import DTO.StudentDTO;
import DTO.UserDTO;

public class LoginPersistence extends AlumNetPersistence{
	private LoginDAO dao;
	
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
	}
	
	public UserDTO login(LoginDTO dto) throws SQLException, Exception {
		//connect to database
		connect();
		
		//create dao with connection
		dao = new LoginDAO(getConnection());
		
		StudentDTO sdto = (StudentDTO) dao.select(dto);
		
		if (sdto.getStudentID() == Integer.MIN_VALUE) {
			AlumniDTO adto = (AlumniDTO) dao.select(dto);	
			return adto;
		}
		
		return sdto;
	}
}
