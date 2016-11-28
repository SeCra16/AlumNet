package persistence;

import java.sql.SQLException;

import dao.LoginDAO;
import dto.AlumniDTO;
import dto.LoginDTO;
import dto.StudentDTO;
import dto.UserDTO;

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

		close();
	}
	
	public UserDTO login(LoginDTO dto) throws SQLException, Exception {
		//connect to database
		connect();
		
		//create dao with connection
		dao = new LoginDAO(getConnection());
		
		StudentDTO sdto = (StudentDTO) dao.select(dto);
		
		if (sdto.getStudentID() == Integer.MIN_VALUE) {
			AlumniDTO adto = (AlumniDTO) dao.select(dto);
            close();
			return adto;
		}

		close();
		return sdto;
	}
}
