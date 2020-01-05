package sample.tests;

import org.junit.Test;
import sample.mosels.Admin;

import static org.junit.Assert.assertEquals;

public class AdminTest {

    Admin admin = new Admin(1,"admin","pass");

    @Test
    public void getIdTest() {
        assertEquals(1, admin.getId(), 1);
    }

    @Test
    public void setIdTest() {
        admin.setId(1);
        assertEquals(1, admin.getId(), 1);
    }

    @Test
    public void getEmailTest() {
        assertEquals("admin", admin.getEmail());
    }

    @Test
    public void setEmailTest() {
        admin.setEmail("admin");
        assertEquals("admin", admin.getEmail());
    }

    @Test
    public void getPasswordTest() {
        assertEquals("pass", admin.getPassword());
    }

    @Test
    public void setPasswordTest() {
        admin.setPassword("pass");
        assertEquals("pass", admin.getPassword());
    }

    @Test
    public void ToStringTest(){
        assertEquals("admin{id=1, email=admin, password=pass}",admin.toString());
    }


}
