package services;

import com.opensymphony.xwork2.ActionSupport;
import dto.AlumniDTO;
import dto.LoginDTO;
import dto.StudentDTO;
import dto.UserDTO;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import persistence.AlumNetFactory;
import persistence.AlumniPersistence;
import persistence.LoginPersistence;
import persistence.StudentPersistence;
import util.ANConstants;

import java.sql.SQLException;
import java.util.Map;

public class LoginService extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private LoginDTO loginDTO;
	private String type;
	private SessionMap<String, Object> sessionMap;
	
	public String validateUser() {
		//validate the users credentials
		try {
		    LoginPersistence lPer = AlumNetFactory.getLoginPersistence();
		    
		    UserDTO user = null;
		    //check login type if it doesn't already exists
			if (loginDTO.getType() == null) {
                type = lPer.checkType(loginDTO);
            } else {
			    type = loginDTO.getType();
            }
		    if (type != null) {
                if (type.equals("alumnus")) {
                    user = (AlumniDTO) lPer.login(loginDTO);

                    AlumniDTO dto = new AlumniDTO();
                    dto.setEmail(loginDTO.getEmail());

                    AlumniPersistence persistence = AlumNetFactory.getAlumniPersistence();
                    dto = persistence.viewAlumnus(dto);

                    sessionMap.put("user", dto);
                } else if (type.equals("student")) {
                    user = (StudentDTO) lPer.login(loginDTO);

                    StudentDTO dto = new StudentDTO();
                    dto.setEmail(loginDTO.getEmail());

					StudentPersistence persistence = AlumNetFactory.getStudentPersistence();
					dto = persistence.viewStudent(dto);

                    sessionMap.put("user", dto);
                    sessionMap.put("resume", dto.getResume().getName());
                } else if (type.equals("admin")) {
                    //what to do if they are an admin
                }
            } else {
		        addActionError("Email or password is invalid! Please try again.");
		        return ANConstants.FAIL;
            }
			sessionMap.put("user", user);
			sessionMap.put("type", type);
			sessionMap.put("picture", user.getPicture().getName());
		} catch (SQLException e) {
			e.printStackTrace();
			return ANConstants.ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ANConstants.ERROR;
		}
		
		return ANConstants.SUCCESS;
	}
	
	public String createLogin() {
		try {
			LoginPersistence lPer = AlumNetFactory.getLoginPersistence();
			lPer.addLogin(loginDTO);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ANConstants.SUCCESS;
	}

	public String createLogin(LoginDTO dto) throws Exception {
		try {
			loginDTO = dto;
			if (validateUser().equals(ANConstants.ERROR)) {

                if (sessionMap != null) {
                    if (!sessionMap.containsKey("user"))
                        throw new Exception("User exists already");
                }
                LoginPersistence lPer = AlumNetFactory.getLoginPersistence();
                lPer.addLogin(dto);
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return ANConstants.ERROR;
		}

		return ANConstants.SUCCESS;
	}

    public String deleteLogin(LoginDTO temp) throws Exception {
	    try {
            LoginPersistence lPer = AlumNetFactory.getLoginPersistence();
            lPer.deleteLogin(temp);

            sessionMap.remove("user");
        } catch (Exception e) {
	        System.out.println("Failed to delete the login");
	        return ANConstants.ERROR;
        }
        return ANConstants.SUCCESS;

    }
	
	public LoginDTO getLoginDTO() {
		return loginDTO;
	}
	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap=(SessionMap<String, Object>) map;
	}
	
	public void setType(String t) {
		type = t;
	}
	
	public String getType() {
		return type;
	}

}
