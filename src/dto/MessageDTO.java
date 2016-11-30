package dto;

import java.util.Random;

public class MessageDTO {

	int messageID = new Random().nextInt(10000000);
	String message, alumnusEmail, studentEmail;
	
	public int getMessageID(){
		return messageID;
	}
	
	public void setMessageID(int i){
		messageID = i;
	}
	
	public String getMessage(){
		return message;
	}
	
	public void setMessage(String s){
		message = s;
	}
	
	public void setAlumnusEmail(String e) {
		alumnusEmail = e;
	}
	
	public String getAlumnusEmail() {
		return alumnusEmail;
	}
	
	public void setStudentEmail(String e) {
		studentEmail = e;
	}
	
	public String getStudentEmail() {
		return studentEmail;
	}

}
