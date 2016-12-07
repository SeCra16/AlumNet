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
	
	public StudentDTO addStudent(StudentDTO dto, String password) throws Exception {
	    try {
            //connect to the database
            connect();

            //need to create a login first
            LoginDTO temp = new LoginDTO();

            //set the values
            temp.setEmail(dto.getEmail());
            temp.setPassword(password);
            temp.setType("student");

            LoginService loginService = new LoginService();

            String result = loginService.createLogin(temp);
            //put in own try catch so if it fails to create the student object it will clean up the login...
            try {
                if (result.equals("SUCCESS")) {
                    //close the connection then reopen
                    close();

                    connect();

                    //create dao with connection
                    dao = new StudentDAO(getConnection());
                    //insert the dto into database
                    dao.insert(dto);

                    //try to grab new values
                    String t = dto.getEmail();
                    dto = new StudentDTO();
                    dto.setEmail(t);
                    return (StudentDTO) dao.select(dto);
                } else {
                    throw new Exception("Login is already being used");
                }
            } catch (Exception e) {
                if (e.getMessage().equals("com.microsoft.sqlserver.jdbc.SQLServerException: The conversion of a date data type to a datetime data type resulted in an out-of-range value.")) {
                    throw e;
                }
                throw e;
                //failed to create the student object... delete the login
                /**if (loginService.deleteLogin(temp).equals(ANConstants.SUCCESS)) {
                    System.out.println("Successfully cleaned up after failing to add");
                    throw new Exception("Successfully cleaned up after failing to add");
                } else {
                    System.out.println("Failed to clean up Login table... please contact administrator");
                    throw new Exception("Failed to clean up Login table... please contact administrator");
                }**/
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
