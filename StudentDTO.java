package dto;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StudentDTO extends UserDTO {
	
	int studentID = Integer.MIN_VALUE; //Class Specific Variables
	Date expectedGraduation;
	String major;
	File resume;
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

		public void setExpectedGraduation(String s) throws Exception{
			expectedGraduation = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(s).getTime());
		}

		public String getMajor(){
			return major;
		}
		
		public void setMajor(String s){
			major = s;
		}
		
		public File getResume(){
			return resume;
		}
		
		public void setResume(File f){
			resume = f;
		}

}
