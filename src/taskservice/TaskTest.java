import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private TaskService service;
    private Task task;

    @BeforeEach
    public void setUp() {
        service = new TaskService();
        task = new Task("001", "Homework", "Read chapter 4");
        service.addTask(task);
    }

    @Test
    public void testAddTask() {
        Task newTask = new Task("002", "Workout", "Go for a run");
        service.addTask(newTask);
        assertEquals("Workout", service.getTask("002").getName());
    }

    @Test
    public void testAddDuplicateTaskThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(new Task("001", "Duplicate", "This should fail"));
        });
    }

    @Test
    public void testDeleteTask() {
        service.deleteTask("001");
        assertThrows(IllegalArgumentException.class, () -> service.getTask("001"));
    }

    @Test
    public void testUpdateName() {
        service.updateTaskName("001", "Updated Name");
        assertEquals("Updated Name", service.getTask("001").getName());
    }

    @Test
    public void testUpdateDescription() {
        service.updateTaskDescription("001", "Updated Description");
        assertEquals("Updated Description", service.getTask("001").getDescription());
    }
}