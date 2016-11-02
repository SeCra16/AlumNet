package DTO;

import java.io.File;

public class SystemAdminDTO extends UserDTO {
	
	int id; //Admin ID
	
	int getId(){
		return id;
	}
	
	void setId(int i){
		id = i;
	}
}
