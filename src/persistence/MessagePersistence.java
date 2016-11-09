package persistence;

import java.sql.SQLException;

import dao.MessageDAO;
import dto.MessageDTO;;

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
	}
}
