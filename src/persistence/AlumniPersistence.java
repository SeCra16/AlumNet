package persistence;


import dao.AlumniDAO;
import dto.AlumniDTO;
import dto.LoginDTO;
import services.LoginService;

import java.sql.SQLException;

public class AlumniPersistence extends AlumNetPersistence{
	private AlumniDAO dao;
	
	public AlumniPersistence() {
		
	}
	
	public void addAlumnus(AlumniDTO dto, String password) throws SQLException, Exception {
		try {
            connect();

            //need to create the login first
            LoginDTO temp = new LoginDTO();

            //set the values
            temp.setEmail(dto.getEmail());
            temp.setPassword(password);
            temp.setType("alumnus");

            LoginService loginService = new LoginService();

            loginService.createLogin(temp);

            if (loginService.equals("SUCCESS")) {
                //close the connection then reopen
                close();

                connect();

                //create dao with connection
                dao = new AlumniDAO(getConnection());

                //insert the dto into database
                dao.insert(dto);
            }
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
