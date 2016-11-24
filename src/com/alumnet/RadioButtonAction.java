package com.alumnet;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;


//This is to map lists to the radio button on registration page
public class RadioButtonAction extends ActionSupport{
    private List<String> StudStatus;
    
    private String yourStatus;
    
    private static final String ALUMNUS = "Alumnus";
    private static final String STUDENT = "Student";
   
    public RadioButtonAction(){
	StudStatus = new ArrayList<String>();
	StudStatus.add(ALUMNUS);
	StudStatus.add(STUDENT);
    }
    
    //return default Student Status
	public String getDefaultStudentStatus(){
		return STUDENT;
	}
	
    @Override
	public String execute() {
		return SUCCESS;
	}
	public String display() {
		return NONE;
	}
}
