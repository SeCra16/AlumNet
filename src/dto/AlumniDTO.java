package dto;

import java.text.SimpleDateFormat;
import java.util.Date;



public class AlumniDTO extends UserDTO {
	//Class Specific Variables
	Date graduationDate;
	String company, jobTitle, jobField;
	//End Class Specific Variables

    public AlumniDTO() {

    }

	public AlumniDTO(AlumniDTO dto) {

	    if (dto.getGraduationDate() != null)
	        setGraduationDate(new java.sql.Date(dto.getGraduationDate().getTime()));
	    if (dto.getConnections() != null)
	        setConnections(dto.getConnections());
	    if (dto.getCompany() != null)
	        setCompany(new String(dto.getCompany()));
	    if (dto.getJobField() != null)
	        setJobField(new String(dto.getJobField()));
	    if (dto.getJobTitle() != null)
	        setJobTitle(new String(dto.getJobTitle()));
        setActive(dto.getActive());
        if (dto.getEmail() != null)
            setEmail(new String(dto.getEmail()));
	    if (dto.getFirstName() != null)
            setFirstName(new String(dto.getFirstName()));
	    if (dto.getLastName() != null)
	        setLastName(new String(dto.getLastName()));
	    if (dto.getPicture() != null)
	        setPicture(dto.getPicture());

    }
	
	//Class Specific Methods
	
	public Date getGraduationDate(){
		return graduationDate;
	}
	
	public void setGraduationDate(Date d){
		graduationDate = d;
	}

	public void setGraduationDate(String s) throws Exception{
		graduationDate = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(s).getTime());
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
