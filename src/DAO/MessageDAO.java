package DAO;
import java.sql.*;

import DTO.MessageDTO;

/*
 * Josh Archer 
 * This class will serve as the DAO (Database Access Object)
 * for the Message table in the database
 * 
 * NOTE: COULD HAVE NULL POINTER ERRORS DUE TO CHECKING FOR CERTAIN VALUES BEFORE CONFIRMING UserDTO OBJECT IS NOT NULL
 */
public class MessageDAO {
	private Connection conn = null;
	
	//constructor
	public MessageDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	public MessageDTO select(MessageDTO dto) throws Exception {
		//Check if the UserDTO is null
		MessageDTO rDTO = new MessageDTO();

		if(dto == null) {
			throw new Exception("DTO passed cannot be null nor can the Id be");
		} else {
			if (dto.getReceiver() != Integer.MIN_VALUE || dto.getSender() != Integer.MIN_VALUE) {
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery("SELECT * FROM Messages WHERE Sender=" + dto.getSender() + " AND Receiver=" + dto.getReceiver());
								
				try {
					rDTO.setSender(rs.getInt("Sender"));
					rDTO.setReceiver(rs.getInt("Receiver"));
					rDTO.setMessage(rs.getString("Message"));

				} catch (SQLException e) {
					throw new SQLException("Problem with data pulled from Database....");
				}
				
			}
		}
		return rDTO;
	}

	
	public void insert(MessageDTO dto) throws Exception {
		//Check if the UserDTO is null
		if(dto == null) {
			throw new Exception("DTO passed cannot be null");
		} else {
			
			//Check if any field of the UserDTO is empty *NOTE: Only picture can be null/empty*
			if (dto.getSender() == Integer.MIN_VALUE) {
				throw new Exception("Sender cannot be empty... failing to attempt insert");
			} else if (dto.getReceiver() == Integer.MIN_VALUE) {
				throw new Exception("Receiver cannot be empty... failing to attempt insert");
			} else if (dto.getMessage() == null) {
				throw new Exception("Message cannot be empty... failing to attempt insert");
			} 
			
			//We know every field is initialized so we can insert
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("INSERT INTO Messages VALUES (" + dto.getSender() + ","+ dto.getReceiver() + ","
					+ dto.getMessage() + ")");
		}
	}

	
	public void delete(MessageDTO dto) throws Exception {
		//Check if the UserDTO is null
		if(dto == null) {
			throw new Exception("DTO passed cannot be null");
		} else {
			//Has to have alumni id so we can delete 
			if (dto.getSender() == Integer.MIN_VALUE || dto.getReceiver() == Integer.MIN_VALUE || dto.getMessage() == null) {
				throw new Exception("Alumni Id cannot be null");
			} else {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("DELETE FROM Messages WHERE Sender=" + dto.getSender() + " AND Receiver=" + dto.getReceiver()
						+ " AND Message=" + dto.getMessage());
			}
		}
	}
}
