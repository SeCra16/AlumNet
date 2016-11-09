package junit;

import dao.MessageDAO;
import dto.MessageDTO;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Archer on 11/9/16.
 * Does not need update, since we do not allow message updating
 */
public class MessageDAOTest extends TestCase {
    Connection conn;
    MessageDAO dao = null;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        conn = DriverManager.getConnection("");

        //set the dao up
        this.dao = new MessageDAO(conn);
    }

    @Test
    public void testSelect() {

        MessageDTO dto = new MessageDTO();

        //need test id
        dto.setSender(1);
        dto.setReceiver(2);

        try {
            dto = dao.select(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertNotSame(dto.getMessage(), "test");
    }

    @Test
    public void testInsert() {

    }

    @Test(expected=Exception.class)
    public void testDelete() throws Exception {
        MessageDTO dto = new MessageDTO();

        //set test variables
        dto.setSender(000);
        dto.setReceiver(000);
        dto.setMessage("unit test");

        dao.insert(dto);

        //now check if it inserted, fail if not
        MessageDTO testDto = dao.select(dto);

        if (testDto.getMessage() != dto.getMessage()) {
            fail("Did not insert the test object");
        }

        if (testDto.getSender() != dto.getSender()) {
            fail("Did not insert the test object");
        }

        if (testDto.getReceiver() != dto.getReceiver()) {
            fail("Did not insert the test object");
        }

        //attempt the delete

        dao.delete(testDto);

        try {

            testDto = dao.select(testDto);

        } catch (Exception e) {

        }

    }
}
