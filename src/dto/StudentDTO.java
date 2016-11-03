package dto;

import java.sql.Clob;
import java.util.Date;

public class StudentDTO extends UserDTO {
	
	int studentID = Integer.MIN_VALUE; //Class Specific Variables
	Date expectedGraduation;
	String major;
	Clob resume;
	//End Class Specific Variables
	

		public int getStudentID(){
			return studentID;
		}
		
		public void setStudentID(int i){
			studentID = i;
		}
		
		public Date getExpectedGraduation(){
			return expectedGraduation;
		}
		
		public void setExpectedGraduation(Date d){
			expectedGraduation = d;
		}
		
		public String getMajor(){
			return major;
		}
		
		public void setMajor(String s){
			major = s;
		}
		
		public Clob getResume(){
			return resume;
		}
		
		public void setResume(Clob f){
			resume = f;
		}

}
