package services;

import com.opensymphony.xwork2.ActionSupport;
import dto.AlumniDTO;
import dto.StudentDTO;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import persistence.AlumNetFactory;
import persistence.AlumniPersistence;
import persistence.StudentPersistence;
import util.ANConstants;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class UserService extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private AlumniDTO alumnus;
	private StudentDTO student;
	private SessionMap<String,Object> sessionMap;
	
	//method to add student
		public String addStudent() {
			try {
				//Get a unique persistence for student
				StudentPersistence persistence = AlumNetFactory.getStudentPersistence();
				
				persistence.addStudent(student);

                //** TO-DO: CREATE LOGIN CODE THAT WILL GIVE USER DTO AS WELL AS CREATE THE LOGIN **//

			} catch (SQLException e) {
				e.printStackTrace();
				return ANConstants.ERROR;
			} catch (Exception e) {
				e.printStackTrace();
				return ANConstants.ERROR;
			}
			return ANConstants.SUCCESS;
		}
		
		public String viewStudent() {
			try {
				//Get a unique persistence for student
				StudentPersistence persistence = AlumNetFactory.getStudentPersistence();
				
				setStudent(persistence.viewStudent(student));
				sessionMap.put("user",getStudent());
			} catch (SQLException e) {
				e.printStackTrace();
				return ANConstants.ERROR;
			} catch (Exception e) {
				e.printStackTrace();
				return ANConstants.ERROR;
			}
			return ANConstants.SUCCESS;
		}
		
		public String updateStudent() {
			try {
				//Get a unique persistence for student
				StudentPersistence persistence = AlumNetFactory.getStudentPersistence();
				
				setStudent(persistence.updateStudent(student));
				sessionMap.put("user",getStudent());
			} catch (SQLException e) {
				e.printStackTrace();
				return ANConstants.ERROR;
			} catch (Exception e) {
				e.printStackTrace();
				return ANConstants.ERROR;
			}
			return ANConstants.SUCCESS;
		}
		
		//accessors and mutators for studentdto
		public StudentDTO getStudent() {
			return student;
		}
		
		public void setStudent(StudentDTO dto) {
			this.student = dto;
		}
	
	
	//method to add Alumni
	public String addAlumnus() {
		try {
			//Get a unique persistence for Alumni
			AlumniPersistence persistence = AlumNetFactory.getAlumniPersistence();
			alumnus.setAlumniID(new Random().nextInt(100000));
			
			persistence.addAlumnus(alumnus);
		} catch (SQLException e) {
			e.printStackTrace();
			return ANConstants.ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ANConstants.ERROR;
		}
		return ANConstants.SUCCESS;
	}
	
	//method to view Alumnus
	public String viewAlumnus() {
		try {
			//Get a unique persistence for Alumni
			AlumniPersistence persistence = AlumNetFactory.getAlumniPersistence();
			
			setAlumnus(persistence.viewAlumnus(alumnus));
			sessionMap.put("user", getAlumnus());
		} catch (SQLException e) {
			e.printStackTrace();
			return ANConstants.ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ANConstants.ERROR;
		}
		return ANConstants.SUCCESS;
	}
	
	//accessors and mutators for Alumnidto
	public AlumniDTO getAlumnus() {
		return alumnus;
	}
	
	public void setAlumnus(AlumniDTO dto) {
		this.alumnus = dto;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap=(SessionMap<String, Object>) map;
	}
	
	public String setupRegistration() {
	    return ANConstants.SUCCESS;
	}
	
	public List<String> majors = ANConstants.MAJORS;

//then getters and setters 

	public void setMajors(List<String> m){
	    majors = m;
	}

	public List<String> getMajors() {
	    return majors;
	}
}