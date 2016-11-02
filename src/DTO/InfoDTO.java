package DTO;

public class InfoDTO {

	String jobField, major;
	int id;
	
	String getJobField(){
		return jobField;
	}
	
	void setJobField(String s){
		jobField = s;
	}
	
	String getMajor(){
		return major;
	}
	
	void setMajor(String s){
		major = s;
	}
	
	int getId(){
		return id;
	}
	
	void setId(int i){
		id = i;
	}
}
