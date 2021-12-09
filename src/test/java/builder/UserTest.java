package builder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;
    ByteArrayOutputStream data = new ByteArrayOutputStream();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.setOut(new PrintStream(data));
        user = User.builder()
                .firstName("Daria")
                .lastName("Kuzmina")
                .occupation("Student")
                .occupation("UCU")
                .age(18)
                .build();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.setOut(System.out);
    }


    @org.junit.jupiter.api.Test
    public void toStringTest() {
        System.out.println(user);
        assertTrue(data.toString().contains("User(firstName=Daria, lastName=Kuzmina, occupations=[Student, UCU], gender=null, age=18, weight=0)"));
    }
}