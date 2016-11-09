package dto;

import java.util.Date;

public class AlumniDTO extends UserDTO {
	
	int alumniID = Integer.MIN_VALUE; //Class Specific Variables
	java.sql.Date graduationDate;
	String company, jobTitle, jobField;
	//End Class Specific Variables
	
	
	//Class Specific Methods
	
	public int getAlumniID(){
		return alumniID;
	}
	
	public void setAlumniID(int i){
		alumniID = i;
	}
	
	public Date getGraduationDate(){
		return graduationDate;
	}
	
	public void setGraduationDate(java.sql.Date d){
		graduationDate = d;
	}
	
	public String getCompany(){
		return company;
	}
	
	public void setCompany(String s){
		company = s;
	}

	public String getJobTitle(){
		return jobTitle;
	}
	
	public void setJobTitle(String s){
		jobTitle = s;
	}
	
	public String getJobField(){
		return jobField;
	}
	
	public void setJobField(String s){
		jobField = s;
	}
	//End Class Specific Methods

}
