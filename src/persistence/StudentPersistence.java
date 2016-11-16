package persistence;

import java.sql.SQLException;

import dao.StudentDAO;
import dto.StudentDTO;

public class StudentPersistence extends AlumNetPersistence{
	private StudentDAO dao;
	
	//default constructor
	public StudentPersistence() {
		
	}
	
	public void addStudent(StudentDTO dto) throws SQLException, Exception {
		//connect to the database
		connect();
		
		//create dao with connection
		dao = new StudentDAO(getConnection());
		
		//insert the dto into database
		dao.insert(dto);
		close();
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
