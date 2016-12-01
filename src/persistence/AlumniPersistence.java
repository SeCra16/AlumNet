package persistence;


import dao.AlumniDAO;
import dto.AlumniDTO;
import dto.LoginDTO;
import services.LoginService;
import util.ANConstants;

import java.sql.SQLException;

public class AlumniPersistence extends AlumNetPersistence{
	private AlumniDAO dao;
	
	public AlumniPersistence() {
		
	}
	
	public void addAlumnus(AlumniDTO dto, String password) throws Exception {
		try {
            connect();

            //need to create the login first
            LoginDTO temp = new LoginDTO();

            //set the values
            temp.setEmail(dto.getEmail());
            temp.setPassword(password);
            temp.setType("alumnus");

            LoginService loginService = new LoginService();

            String result = loginService.createLogin(temp);
            try {
                if (result.equals("SUCCESS")) {
                    //close the connection then reopen
                    close();

                    connect();

                    //create dao with connection
                    dao = new AlumniDAO(getConnection());

                    //insert the dto into database
                    dao.insert(dto);
                }
            } catch (Exception e) {
                //failed to create the student object... delete the login

                if (loginService.deleteLogin(temp).equals(ANConstants.SUCCESS)) {
                    System.out.println("Successfully cleaned up after failing to add");
                } else {
                    System.out.println("Failed to clean up Login table... please contact administrator");
                }
                throw new Exception(e.getMessage() + "... Failed to clean up Login table... please contact administrator");
            }
        } catch (Exception e) {
            throw e;
        } finally {
		    close();
        }
	}

	public AlumniDTO viewAlumnus(AlumniDTO alumnus) throws SQLException, Exception {
		connect();
		dao = new AlumniDAO(getConnection());

        AlumniDTO dto = (AlumniDTO) dao.select(alumnus);

        close();
		return dto;
	}
	
}
