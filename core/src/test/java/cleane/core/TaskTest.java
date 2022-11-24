package cleane.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest{

    public Task newTask;
    @BeforeEach
    public void setUp() {
        newTask = new Task("task", null, new Person("person1"));
    }

    @Test
    public void testGetFields() {
        newTask.setDescription("A task");
        LocalDate deadline = LocalDate.of(2069, 4, 20);
        newTask.setDeadline(deadline);
        Person person = new Person("Karl Marx");
        newTask.setPerson(person);
        assertEquals("A task", newTask.getDescription());
        assertEquals(deadline, newTask.getDeadline());
        assertEquals("Karl Marx", newTask.getPerson().getName());
    }

    @Test
    public void testConstructor() {
        Task task = new Task();
        assertEquals(null, task.getDeadline());
        assertEquals(null, task.getDescription());
        assertEquals(null, task.getPerson().getName());
    }
}