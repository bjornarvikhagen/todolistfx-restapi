package cleane.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class PeopleTest {
    
    @Test
    public void testPeople() {
        People people = new People();
        Person person = new Person();
        Person person2 = new Person();
        person.setName("person1");
        person2.setName("person2");
        people.add(person);
        people.add(person2);
        assertEquals("person2", people.get(1).getName());

        ArrayList<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person2);
        People people2 = new People(list);
        assertEquals("person1", people2.get(0).getName());

        assertEquals(people.getPeople(), list);
    }
}
