package persistence;


import java.sql.SQLException;

import dao.AlumniDAO;
import dto.AlumniDTO;

public class AlumniPersistence extends AlumNetPersistence{
	private AlumniDAO dao;
	
	public AlumniPersistence() {
		
	}
	
	public void addAlumnus(AlumniDTO dto) throws SQLException, Exception {
		connect();
		dao = new AlumniDAO(getConnection());
		
		dao.insert(dto);
	}

	public AlumniDTO viewAlumnus(AlumniDTO alumnus) throws SQLException, Exception {
		connect();
		dao = new AlumniDAO(getConnection());
		
		return (AlumniDTO) dao.select(alumnus);		
	}
	
}
