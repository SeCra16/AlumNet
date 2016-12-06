package junit.services;

import dto.StudentDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import services.UserService;

import static org.junit.Assert.assertNotNull;

/** 
* UserService Tester. 
* 
* @author Josh Archer
* @since <pre>Dec 2, 2016</pre> 
* @version 1.0 
*/ 
public class UserServiceTest {
    UserService userService;

@Before
public void before() throws Exception {
    userService = new UserService();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: addStudent() 
* 
*/ 
@Test
public void testAddStudent() throws Exception {
    StudentDTO dto = new StudentDTO();

    //set test values
    dto.setFirstName("test");
    dto.setLastName("alumnet");
    dto.setEmail("testing@alumnet.net");
    dto.setMajor("test");
    dto.setActive(true);

    userService.setStudent(dto);
    userService.addStudent();

    assertNotNull(userService.viewStudent());
} 

/** 
* 
* Method: viewStudent() 
* 
*/ 
@Test
public void testViewStudent() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateStudent() 
* 
*/ 
@Test
public void testUpdateStudent() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getStudent() 
* 
*/ 
@Test
public void testGetSetStudent() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addAlumnus() 
* 
*/ 
@Test
public void testAddAlumnus() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: viewAlumnus() 
* 
*/ 
@Test
public void testViewAlumnus() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getAlumnus() 
* 
*/ 
@Test
public void testGetSetAlumnus() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setSession(Map<String, Object> map) 
* 
*/ 
@Test
public void testSetSession() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setupRegistration() 
* 
*/ 
@Test
public void testSetupRegistration() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setMajors(List<String> m) 
* 
*/ 
@Test
public void testGetSetMajors() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setPassword(String p) 
* 
*/ 
@Test
public void testSetPassword() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getJobFields() 
* 
*/ 
@Test
public void testGetSetJobFields() throws Exception { 
//TODO: Test goes here... 
} 


} 
