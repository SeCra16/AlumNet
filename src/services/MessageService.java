package services;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dto.MessageDTO;
import dto.UserDTO;
import persistence.AlumNetFactory;
import persistence.MessagePersistence;
import util.ANConstants;

public class MessageService extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	private SessionMap<String,Object> sessionMap;
	private MessageDTO message;
	
	//this should work unless
	
	public String sendMessage() {
		
		try {
			//get persistence from the alumnet factory object
			MessagePersistence mPer = AlumNetFactory.getMessagePersistence();
			
			mPer.addMessage(message);
		} catch (Exception e) {
			System.out.println("Hit an error adding message: " + e.getMessage());
			return ANConstants.ERROR;
		}
		
		return ANConstants.SUCCESS;
	}
	
	public MessageDTO[] viewMessages() {
		
		
		return null;
	}
	
	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap=(SessionMap<String, Object>) map;
	}

	//getters and setters for the ActionSupport
	public MessageDTO getMessage() {
		return message;
	}

	public void setMessage(MessageDTO message) {
		this.message = message;
	}
	
}
