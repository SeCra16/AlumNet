package dto;

public class MessageDTO {

	int messageID, connectionID;
	String message;
	
	public int getMessageID(){
		return messageID;
	}
	
	public void setMessageID(int i){
		messageID = i;
	}
	
	public int getConnectionID(){
		return connectionID;
	}

	public void setConnectionID(int i){
		connectionID = i;
	}
	
	public String getMessage(){
		return message;
	}
	
	public void setMessage(String s){
		message = s;
	}


}
