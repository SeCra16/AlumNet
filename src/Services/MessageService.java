package Services;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import DTO.MessageDTO;

public class MessageService extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	private SessionMap<String,Object> sessionMap;
	
	public String sendMessage(MessageDTO dto) {
		//code to send message
		return null;
	}
	
	public MessageDTO[] viewMessages() {
		//code to get messages
		return null;
	}
	
	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap=(SessionMap<String, Object>) map;
	}
	
}
