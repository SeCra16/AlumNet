package dto;
import java.sql.Clob;

public class UserDTO {
	String FirstName, LastName, Email;
	boolean active;
	int[] connections;
	Clob Picture;
	
	public String getFirstName() {
		String temp = new String(FirstName);
		return temp;
	}
	public void setFirstName(String s) {
		FirstName = s;
	}
	
	public String getLastName() {
		String temp = new String(LastName);
		return temp;
	}
	public void setLastName(String s) {
		LastName = s;
	}
	
	public String getEmail() {
		String temp = new String(Email);
		return temp;
	};
	public void setEmail(String s) {
		Email = s;
	}
	
	public boolean getActive() {
		return active;
	}
	public void setActive(Boolean b) {
		active = b;
	}
	
	public int[] getConnections() {
		return connections;
	}
	public void setConnections(int[] ia) {
		connections = ia;
	}
	
	public Clob getPicture() {
		return Picture;
	}
	public void setPicture(Clob clob) {
		Picture = clob;
	}
}
