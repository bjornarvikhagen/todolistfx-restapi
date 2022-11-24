package cleane.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValuesTest {
    
    private Values values;

    @BeforeEach
    public void testValues() {
        Person person1 = new Person("person1");
        Person person2 = new Person("person2");
        LocalDate deadline1 = LocalDate.of(2022, 12, 24);
        LocalDate deadline2 = LocalDate.of(2023, 10, 5);
        String desc1 = "desc1";
        String desc2 = "desc2";

        People people = new People();
        people.add(person1);
        people.add(person2);
        Tasks tasks = new Tasks();
        tasks.add(new Task(desc1, deadline1, person1));
        tasks.add(new Task(desc2, deadline2, person2));
        Values values = new Values(people, tasks);
        this.values = values;
    }

    @Test
    public void testGetFields() {
        People people = values.getPeople();
        Tasks tasks = values.getTasks();
        assertEquals("person1", people.get(0).getName());
        assertEquals("desc2", tasks.getTask(1).getDescription());
        assertEquals(LocalDate.of(2023, 10, 5), tasks.getTask(1).getDeadline());
    }

    @Test
    public void testRemove() {
        values.removePerson(0);
        assertEquals(values.getPeople().get(0).getName(), "person2");
        values.removeTask(0);
        assertEquals(values.getTasks().getTask(0).getDescription(),"desc2");
    }
}
