package DTO;

public class MessageDTO {

	int sender, receiver;
	String message;
	
	public int getSender(){
		return sender;
	}
	
	public void setSender(int i){
		sender = i;
	}
	
	public int getReceiver(){
		return receiver;
	}
	
	public void setReceiver(int i){
		receiver = i;
	}
	
	public String getMessage(){
		return message;
	}
	
	public void setMessage(String s){
		message = s;
	}
}
