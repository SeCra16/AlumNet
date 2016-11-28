package junit;

import dto.StudentDTO;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import services.UserService;

/**
 * Created by Archer on 11/15/16.
 */
public class UserServiceTest extends TestCase {
    UserService userService = null;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        userService = new UserService();
    }


    @Test
    public void addStudentTest() {
        StudentDTO dto = new StudentDTO();

        //set test values
        dto.setFirstName("test");
        dto.setLastName("alumnet");
        dto.setEmail("testing@alumnet.net");
        dto.setStudentID(0);
        dto.setMajor("test");
        dto.setActive(true);

        userService.setStudent(dto);
        userService.addStudent();

        assertNotNull(userService.viewStudent());
    }

    @Test
    public void viewStudentTest() {

    }
}
