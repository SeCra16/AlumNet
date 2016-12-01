package persistence;

import dao.AlumniDAO;
import dao.LoginDAO;
import dao.StudentDAO;
import dto.AlumniDTO;
import dto.LoginDTO;
import dto.StudentDTO;
import dto.UserDTO;

import java.sql.SQLException;

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
	
	
	//what happens if i return this
	public UserDTO login(LoginDTO dto) throws SQLException, Exception {
		//connect to database
		connect();
		
		String type = checkType(dto);
		
		UserDTO sdto = null;
		
		//create dao with connection
		if (type.toLowerCase().equals("alumnus")) {
			AlumniDAO dao = new AlumniDAO(getConnection());
			AlumniDTO temp = new AlumniDTO();
			temp.setEmail(dto.getEmail());
			
			sdto = dao.select(temp);
			
		} else if (type.toLowerCase().equals("student")) {
			StudentDAO dao = new StudentDAO(getConnection());
			StudentDTO temp = new StudentDTO();
			temp.setEmail(dto.getEmail());
			
			sdto = dao.select(temp);
			
		} else if (type.toLowerCase().equals("admin")) {
			//nothing to do now
		}
		
		close();
		return sdto;
	}
	
	public String checkType(LoginDTO dto) throws Exception {
		//connect to database
		connect();
		
		//create dao with connection
		dao = new LoginDAO(getConnection());
		String type = dao.select(dto);
		
		close();
		
		return type;
	}

    public void deleteLogin(LoginDTO temp) throws Exception {

		connect();

		dao = new LoginDAO(getConnection());

		dao.delete(temp);

		close();
    }
}
