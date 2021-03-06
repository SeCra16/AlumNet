package services;

import com.opensymphony.xwork2.ActionSupport;
import dto.AlumniDTO;
import dto.StudentDTO;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import persistence.AlumNetFactory;
import persistence.AlumniPersistence;
import persistence.StudentPersistence;
import util.ANConstants;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserService extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private AlumniDTO alumnus;
	private StudentDTO student;
	private String password;
	private SessionMap<String,Object> sessionMap;
	private List<String> majors;
	private List<String> jobFields;
	
	//method to add student
		public String addStudent() {
            try {
                //Get a unique persistence for student
                StudentPersistence persistence = AlumNetFactory.getStudentPersistence();

                StudentDTO temp = persistence.addStudent(student, password);

                if (temp != null) {
                    student = temp;
                }


                //store the user we inserted in the session
                sessionMap.put("user", student);
                sessionMap.put("type", "student");
                sessionMap.put("picture", student.getPicture().getName());
                sessionMap.put("resume", student.getResume().getName());


                //set up picture for front end
                String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("userimages");

                System.out.println("Image Location:" + filePath);//see the server console for actual location
                File fileToCreate = new File(filePath, student.getPicture().getName());
                FileUtils.copyFile(student.getPicture(), fileToCreate);//copying source file to new file

				//set up resume for front end
                filePath = ServletActionContext.getServletContext().getRealPath("/").concat("userresume");

                System.out.println("Image Location:" + filePath);//see the server console for actual location
                fileToCreate = new File(filePath, student.getResume().getName());
                FileUtils.copyFile(student.getResume(), fileToCreate);//copying source file to new file

            } catch (SQLException e) {
                e.printStackTrace();
                return ANConstants.ERROR;
            } catch (NullPointerException n) {
                n.printStackTrace();
                return ANConstants.ERROR;
            } catch (Exception e) {
                e.printStackTrace();
			    if (e.getMessage().equals("Successfully cleaned up after failing to add") || e.getMessage().equals("Failed to clean up Login table... please contact administrator")) {
			        return "user";
                }
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

				//store new user in session
				sessionMap.put("user",getStudent());

				//store the type of user in session
                sessionMap.put("type", "student");
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
			
			persistence.addAlumnus(alumnus, password);

			//store the user
			sessionMap.put("user", alumnus);

			//store the type of user in session
            sessionMap.put("type", "alumnus");

            sessionMap.put("picture", alumnus.getPicture().getName());


            //set up picture for front end
            String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("userimages");

            System.out.println("Image Location:" + filePath);//see the server console for actual location
            File fileToCreate = new File(filePath, alumnus.getPicture().getName());
            FileUtils.copyFile(alumnus.getPicture(), fileToCreate);//copying source file to new file

		} catch (com.microsoft.sqlserver.jdbc.SQLServerException e) {
			e.printStackTrace();
			return ANConstants.ERROR;
		} catch (Exception e) {
            if (e.getMessage().equals("Successfully cleaned up after failing to add") || e.getMessage().equals("Failed to clean up Login table... please contact administrator")) {
                return "user";
            }
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

			//store session data
			sessionMap.put("user", getAlumnus());
			sessionMap.put("type", "alumnus");
		} catch (SQLException e) {
			e.printStackTrace();
			return ANConstants.ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ANConstants.ERROR;
		}
		return ANConstants.SUCCESS;
	}

	public String updateAll() {
		    try {
                if (sessionMap.get("type") == null) {
                    return ANConstants.ERROR;
                } else {
                    if (sessionMap.get("type").equals("alumnus")) {
                        AlumniPersistence persistence = AlumNetFactory.getAlumniPersistence();

                        //get the list of connections
                        AlumniDTO alumniDTO = (AlumniDTO) sessionMap.get("user");
                       // String[] emails = alumniDTO.getConnections();

                       /// for (String email : emails) {

                            //alumniDTO.set
                            setAlumnus(persistence.insertAlumnusConnections(alumniDTO));
                            sessionMap.put("user", alumnus);
                        //}

                        return ANConstants.SUCCESS + "a";
                    } else if (sessionMap.get("type").equals("student")) {

                        StudentPersistence persistence = AlumNetFactory.getStudentPersistence();

                        //get the list of connections
                        StudentDTO studentDTO = (StudentDTO) sessionMap.get("user");
                        //String[] emails = studentDTO.getConnections();

                       // for (String email : emails) {

                            //studentDTO.set
                            setStudent(persistence.insertStudentConnections(studentDTO));
                            sessionMap.put("user", student);
                        //}
                        return ANConstants.SUCCESS + "s";
                    }
                }
            } catch (Exception e) {
		        return ANConstants.ERROR;
            }

            return ANConstants.FAIL;
    }

    public String logoutUser() {
        sessionMap.clear();
        return ANConstants.SUCCESS;
	}
	
	//accessors and mutators
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
		setMajors(ANConstants.MAJORS);
	    return ANConstants.SUCCESS;
	}

	public void setMajors(List<String> m){
	    majors = m;
	}

	public List<String> getMajors() {
	    return majors;
	}

	public void setPassword(String p) {password = p;}


	public List<String> getJobFields() {
		return jobFields;
	}

	public void setJobFields(List<String> jobFields) {
		this.jobFields = jobFields;
	}
}
