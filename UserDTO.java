package dto;
import java.io.File;

public class UserDTO {
	String FirstName, LastName, Email;
	boolean active = true;
	int[] connections;
	File Picture;
	
	public String getFirstName() {
		String temp = FirstName;
		return temp;
	}
	public void setFirstName(String s) {
		FirstName = s;
	}
	
	public String getLastName() {
		String temp = LastName;
		return temp;
	}
	public void setLastName(String s) {
		LastName = s;
	}
	
	public String getEmail() {
		return Email;
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
	
	public File getPicture() {
		return Picture;
	}
	public void setPicture(File clob) {
		Picture = clob;
	}
}
