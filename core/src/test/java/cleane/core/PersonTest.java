package cleane.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {

    public Person person;

    @BeforeEach
    public void setUp() {
        person = new Person("person1");
    }

    @Test
    public void testGetFields() {
        person.setName("Person2");
        assertEquals("Person2", person.getName());
    }
}