package dto;

public class LoginDTO {

	String email = null;
	String password;
	String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type.toLowerCase();
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String s){
		email = s.toLowerCase();
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String s){
		password = s;
	}
}
