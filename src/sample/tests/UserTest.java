package sample.tests;

import org.junit.Test;
import sample.mosels.Admin;
import sample.mosels.User;

import static org.junit.Assert.assertEquals;

public class UserTest {

    User user = new User("Farida","Bagirova","farida01","12345");
    @Test
    public void getfirstnameTest() {
        assertEquals("Farida",user.getFirstName());
    }

    @Test
    public void setfirstnameTest() {
        user.setFirstName("Farida");
        assertEquals("Farida",user.getFirstName());
    }

    @Test
    public void getLasnameTest() {
        assertEquals("Bagirova",user.getLastName());
    }

    @Test
    public void setLastnameTest() {
        user.setLastName("Bagirova");
        assertEquals("Bagirova",user.getLastName());
    }

    @Test
    public void getUsernameTest() {
        assertEquals("farida01", user.getUserName());
    }

    @Test
    public void setUsernameTest() {
        user.setUserName("farida01");
        assertEquals("farida01", user.getUserName());
    }

    @Test
    public void getPasswordTest() {
        assertEquals("12345", user.getPassword());
    }

    @Test
    public void setPasswordTest() {
        user.setPassword("12345");
        assertEquals("12345", user.getPassword());
    }


    @Test
    public void toStringTest(){
        assertEquals("user{firtname=Farida, lastname=Bagirova " +
                ",username=farida01, password=12345}",user.toString());
    }
}
