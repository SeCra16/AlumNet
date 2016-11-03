package dto;

public class LoginDTO {

	String email, password;
	int ID = Integer.MIN_VALUE;
	
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
	
	public int getID(){
		return ID;
	}
	
	public void setID(int i){
		ID = i;
	}
}
