package services;

import com.opensymphony.xwork2.ActionSupport;
import dto.MessageDTO;
import dto.UserDTO;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import persistence.AlumNetFactory;
import persistence.MessagePersistence;
import util.ANConstants;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class MessageService extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	private SessionMap<String,Object> sessionMap;
	private MessageDTO message;
    private ArrayList<UserDTO> possConn;
	private ArrayList<MessageDTO> messages;
	
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
	
	public String viewMessages(UserDTO dto) throws Exception {
        MessagePersistence mPer = AlumNetFactory.getMessagePersistence();

        messages = mPer.getAllMessages(dto);
		
		return ANConstants.SUCCESS;
	}

	public String allPossibleConnections() throws Exception {
        MessagePersistence persistence = AlumNetFactory.getMessagePersistence();

        if ((UserDTO) sessionMap.get("user") != null) {
            possConn = persistence.getPossibleConnections((UserDTO) sessionMap.get("user"));

            for (UserDTO temp : possConn) {
                File tFile = new File(temp.getPicture().getName());

                //set up picture for front end
                String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("userimages");

                System.out.println("Image Location:" + filePath);//see the server console for actual location
                File fileToCreate = new File(filePath, tFile.getName());
                FileUtils.copyFile(temp.getPicture(), fileToCreate);//copying source file to new file
                temp.setPicture(tFile);
            }
        } else {
            return  ANConstants.FAIL;
        }


	    return  ANConstants.SUCCESS;
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

	public ArrayList<MessageDTO> getMessages() {return messages;}

	public void setMessages(ArrayList<MessageDTO> m) {this.messages = m;}

    public ArrayList<UserDTO> getPossConn() {
        return possConn;
    }

    public void setPossConn(ArrayList<UserDTO> possConn) {
        this.possConn = possConn;
    }
}
