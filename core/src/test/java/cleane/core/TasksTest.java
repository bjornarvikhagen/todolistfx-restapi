package cleane.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TasksTest {
    
    @Test
    public void testTasks() {
        Tasks tasks = new Tasks();
        Task task = new Task("task1", LocalDate.now(), new Person());
        Task task2 = new Task("task2", LocalDate.of(2023, 5, 20), new Person());
        tasks.add(task);
        tasks.add(task2);
        assertEquals("task1", tasks.getTask(0).getDescription());
        assertEquals(LocalDate.of(2023, 5, 20), tasks.getTask(1).getDeadline());
        
    }

    @Test
    public void testConstructor() {
        List<Task> list = new ArrayList<>();
        list.add(new Task("task1", LocalDate.now(), new Person()));
        list.add(new Task("task2", LocalDate.of(2023, 5, 20), new Person()));
        Tasks tasks = new Tasks(list);
        assertEquals(LocalDate.now(), tasks.getTask(0).getDeadline());
        assertEquals("task2", tasks.getTask(1).getDescription());

        assertEquals(tasks.getTasks(), list);
    }
}
