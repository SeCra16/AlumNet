package services;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dto.LoginDTO;
import dto.UserDTO;
import persistence.AlumNetFactory;
import persistence.LoginPersistence;
import util.ANConstants;

public class LoginService extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	private LoginDTO loginDTO;
	private UserDTO user;
	private String type;
	private SessionMap<String, Object> sessionMap;
	
	public String validateUser() {
		//validate the users credentials
		try {
			LoginPersistence lPer = AlumNetFactory.getLoginPersistence();
			user = lPer.login(loginDTO, type);
			sessionMap.put("user", user);
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
