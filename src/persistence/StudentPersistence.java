package persistence;

import dao.StudentDAO;
import dto.LoginDTO;
import dto.StudentDTO;
import services.LoginService;

import java.sql.SQLException;

public class StudentPersistence extends AlumNetPersistence{
	private StudentDAO dao;
	
	//default constructor
	public StudentPersistence() {
		
	}
	
	public void addStudent(StudentDTO dto, String password) throws SQLException, Exception {
	    try {
            //connect to the database
            connect();

            //need to create a login first
            LoginDTO temp = new LoginDTO();

            //set the values
            temp.setEmail(dto.getEmail());
            temp.setPassword(password);

            LoginService loginService = new LoginService();

            loginService.createLogin(temp);

            if (loginService.equals("SUCCESS")) {
                //close the connection then reopen
                close();

                connect();

                //create dao with connection
                dao = new StudentDAO(getConnection());

                //insert the dto into database
                dao.insert(dto);
            }
        } finally {
	        close();
        }
    }

	public StudentDTO updateStudent(StudentDTO dto) throws SQLException, Exception {
		//connect to the database
		connect();
		
		//create dao with connection
		dao = new StudentDAO(getConnection());
		
		//insert the dto into database
        StudentDTO sDto = (StudentDTO) dao.update(dto);
        close();
		return sDto;
	}

	public StudentDTO viewStudent(StudentDTO student) throws SQLException, Exception {
		//connect to the database
		connect();
		
		//create dao with connection
		dao = new StudentDAO(getConnection());
		
		//insert the dto into database
        StudentDTO sDto = (StudentDTO) dao.select(student);
        close();

		return sDto;
	}
}
