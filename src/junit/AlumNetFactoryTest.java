package junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import persistence.*;

import static org.junit.Assert.assertTrue;

/** 
* AlumNetFactory Tester. 
* 
* @author Josh Archer
* @since <pre>Dec 2, 2016</pre> 
* @version 1.0 
*/ 
public class AlumNetFactoryTest { 

@Before
public void before() throws Exception {

} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getAlumniPersistence() 
* 
*/ 
@Test
public void testGetAlumniPersistence() throws Exception {
    AlumNetPersistence per = AlumNetFactory.getAlumniPersistence();

    AlumNetPersistence per2 = AlumNetFactory.getAlumniPersistence();

    assertTrue(per.isClosed());
} 

/** 
* 
* Method: getStudentPersistence() 
* 
*/ 
@Test
public void testGetStudentPersistence() throws Exception {
    StudentPersistence per = AlumNetFactory.getStudentPersistence();

    StudentPersistence per2 = AlumNetFactory.getStudentPersistence();

    assertTrue(per.isClosed());
} 

/** 
* 
* Method: getLoginPersistence() 
* 
*/ 
@Test
public void testGetLoginPersistence() throws Exception {
    LoginPersistence per = AlumNetFactory.getLoginPersistence();

    LoginPersistence per2 = AlumNetFactory.getLoginPersistence();

    assertTrue(per.isClosed());
} 

/** 
* 
* Method: getMessagePersistence() 
* 
*/ 
@Test
public void testGetMessagePersistence() throws Exception {
    MessagePersistence per = AlumNetFactory.getMessagePersistence();

    MessagePersistence per2 = AlumNetFactory.getMessagePersistence();

    assertTrue(per.isClosed());
} 


} 
