package persistence;

import dao.MessageDAO;
import dto.MessageDTO;
import dto.UserDTO;

import java.sql.SQLException;
import java.util.ArrayList;

;

public class MessagePersistence extends AlumNetPersistence{
	private MessageDAO dao;
	
	//default constructor
	public MessagePersistence() {
		
	}
	
	public void addMessage(MessageDTO dto) throws SQLException, Exception {
		//connect to the database
		connect();
		
		//create dao with connection
		dao = new MessageDAO(getConnection());
		
		//insert the dto into database
		dao.insert(dto);

		close();
	}


	public ArrayList<MessageDTO> getAllMessages(UserDTO dto) throws Exception {
	    //connect
        connect();

        dao = new MessageDAO(getConnection());

        //create a temp MessageDTO
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setAlumnusEmail(dto.getEmail());
        messageDTO.setStudentEmail(dto.getEmail());

        //this will only return the last dto... what to do????? select*??
        ArrayList<MessageDTO> messages = dao.selectAll(messageDTO);

        close();

        return messages;
	}

	public ArrayList<UserDTO> getPossibleConnections() throws Exception {
        connect();

        dao = new MessageDAO(getConnection());

        return dao.selectPossibleConnections();
	}
}
