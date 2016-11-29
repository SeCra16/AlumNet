package dto;

public class LoginDTO {

	String email, password;
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String s){
		email = s;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String s){
		password = s;
	}
}
