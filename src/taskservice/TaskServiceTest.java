import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testValidTaskCreation() {
        Task task = new Task("001", "Grocery", "Buy milk and eggs");
        assertEquals("001", task.getTaskId());
        assertEquals("Grocery", task.getName());
        assertEquals("Buy milk and eggs", task.getDescription());
    }

    @Test
    public void testSetNameValidation() {
        Task task = new Task("002", "Clean", "Vacuum the house");
        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
        assertThrows(IllegalArgumentException.class, () -> task.setName("This name is way too long for the limit"));
    }

    @Test
    public void testSetDescriptionValidation() {
        Task task = new Task("003", "Read", "Finish a book");
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
        assertThrows(IllegalArgumentException.class, () -> task.setDescription("This description is over fifty characters long, which should fail."));
    }
}