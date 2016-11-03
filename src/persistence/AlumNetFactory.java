package persistence;

import java.sql.SQLException;

public class AlumNetFactory {
	private static AlumniPersistence alumPer = null;
	private static StudentPersistence studPer = null;
	private static LoginPersistence logPer = null;
	private static MessagePersistence messPer = null;
	
	public static AlumniPersistence getAlumniPersistence() throws SQLException {
		if (alumPer != null) {
			alumPer.close();
		}
		alumPer = new AlumniPersistence();
		return alumPer;
	}
	
	public static StudentPersistence getStudentPersistence() throws SQLException {
		if (studPer != null) {
			studPer.close();
		}
		studPer = new StudentPersistence();
		return studPer;
	}
	
	public static LoginPersistence getLoginPersistence() throws SQLException{
		if (logPer != null) {
			logPer.close();
		}
		logPer = new LoginPersistence();
		return logPer;
	}
	
	public static MessagePersistence getMessagePersistence() throws SQLException{
		if (messPer != null) {
			messPer.close();
		}
		messPer = new MessagePersistence();
		return messPer;
	}
}
