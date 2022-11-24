package cleane.restapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cleane.core.People;
import cleane.core.Person;

public class ValuesServiceTest {
    
    private People people;
    ValuesService service;

    @BeforeEach
    public void init() {         // SERVER MUST BE On 
        service = new ValuesService();
    }

    @Test
    public void testGetValues() throws IOException {
        people = service.getPeople();

        Person person = new Person("test");
        Person person2 = new Person("test3");

        assertEquals(person.getName(), people.get(0).getName());
        assertEquals(person2.getName(), people.get(1).getName());
    }
}
