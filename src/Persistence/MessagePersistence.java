package Persistence;

import java.sql.SQLException;

import DAO.MessageDAO;
import DTO.MessageDTO;;

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
