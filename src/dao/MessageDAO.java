package dao;
import dto.MessageDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Josh Archer 
 * This class will serve as the dao (Database Access Object)
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
			throw new Exception("dto passed cannot be null nor can the Id be");
		} else {
			Statement stmt = conn.createStatement();
			ResultSet rs = null;
			if (dto.getMessageID() != Integer.MIN_VALUE) { 
				rs = stmt.executeQuery("SELECT * FROM ALUMNET.dbo.Messages WHERE Message_ID=" + dto.getMessageID());
			}
			else if (dto.getAlumnusEmail() != null && dto.getStudentEmail() != null && dto.getMessage() != null) {
				rs = stmt.executeQuery("SELECT * FROM ALUMNET.dbo.Messages WHERE Alumni_Email=" + dto.getAlumnusEmail() + " and Message=" + dto.getMessage() + " and Student_Email=" + dto.getStudentEmail());
			} else {
				throw new Exception ("Message ID, Alumnus Email, or Student Email must have a value");
			}
			
			//get values
			int i = 0;
			while (rs.next()) {
				i++;
				if (i > 1) {

				}
				rDTO.setMessageID(rs.getInt("Message_ID"));
				rDTO.setAlumnusEmail(rs.getString("Alumni_Email"));
				rDTO.setStudentEmail(rs.getString("Student_Email"));
				rDTO.setMessage(rs.getString("Message"));
			}
				
		}
		return rDTO;
	}

	
	public void insert(MessageDTO dto) throws Exception {
		//Check if the UserDTO is null
		if(dto == null) {
			throw new Exception("dto passed cannot be null");
		} else {
			
			//Check if any field of the UserDTO is empty *NOTE: Only picture can be null/empty*
			if (dto.getMessageID() == Integer.MIN_VALUE) {
				throw new Exception("MessageID cannot be empty... failing to attempt insert");
			} else if (dto.getMessage() == null) {
				throw new Exception("Message cannot be empty... failing to attempt insert");
			} else if (dto.getAlumnusEmail() == null) {
				throw new Exception("Alumnus email cannot be empty... failing to attempt insert");
			} else if (dto.getStudentEmail() == null) {
				throw new Exception("Student email cannot be empty... failing to attempt insert");
			}
			
			//We know every field is initialized so we can insert
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO ALUMNET.dbo.Messages (Message_ID, Alumni_Email, Student_Email, Message) VALUES (?,?,?,?)");

			stmt.setInt(1, dto.getMessageID());
			stmt.setString(2, dto.getAlumnusEmail());
			stmt.setString(3, dto.getStudentEmail());
			stmt.setString(4, dto.getMessage());

			stmt.execute();
		}
	}

    public ArrayList<MessageDTO> selectAll(MessageDTO dto) throws Exception {
        //Check if the UserDTO is null
        ArrayList<MessageDTO> messages = new ArrayList<>();

        if(dto == null) {
            throw new Exception("dto passed cannot be null nor can the Id be");
        } else {
            Statement stmt = conn.createStatement();
            ResultSet rs = null;

            if (dto.getAlumnusEmail() != null && dto.getStudentEmail() != null) {
                rs = stmt.executeQuery("SELECT * FROM ALUMNET.dbo.Messages WHERE Alumni_Email=" + dto.getAlumnusEmail() + " and Student_Email=" + dto.getStudentEmail());
            } else {
                throw new Exception ("Alumnus Email, or Student Email must have a value");
            }

            //get values
            while (rs.next()) {
                MessageDTO rDTO = new MessageDTO();
                rDTO.setMessageID(rs.getInt("Message_ID"));
                rDTO.setAlumnusEmail(rs.getString("Alumni_Email"));
                rDTO.setStudentEmail(rs.getString("Student_Email"));
                rDTO.setMessage(rs.getString("Message"));

                //now set the dto into the arraylist
                messages.add(rDTO);
            }

        }
        return messages;
    }
}
