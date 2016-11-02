package Services;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import DTO.LoginDTO;
import Persistence.AlumNetFactory;
import Persistence.LoginPersistence;
import Util.ANConstants;

public class LoginService extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private LoginDTO loginDTO;
	
	public String validateUser() {
		//validate the users credentials
		try {
			LoginPersistence lPer = AlumNetFactory.getLoginPersistence();
			lPer.login(loginDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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
}
