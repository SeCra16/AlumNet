package Persistence;

import java.sql.SQLException;

import DAO.StudentDAO;
import DTO.StudentDTO;

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
	}

	public StudentDTO updateStudent(StudentDTO dto) throws SQLException, Exception {
		//connect to the database
		connect();
		
		//create dao with connection
		dao = new StudentDAO(getConnection());
		
		//insert the dto into database
		return (StudentDTO) dao.update(dto);		
	}

	public StudentDTO viewStudent(StudentDTO student) throws SQLException, Exception {
		//connect to the database
		connect();
		
		//create dao with connection
		dao = new StudentDAO(getConnection());
		
		//insert the dto into database
		return (StudentDTO) dao.select(student);
	}
}
