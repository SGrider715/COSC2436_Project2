import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class AppointmentBSTTest {

    @Test
    void testInsertAndInOrderTraversal() {
        AppointmentBST bst = new AppointmentBST();
        bst.addAppointment(new PatientAppointment(1, "Alice", "09:00"));
        bst.addAppointment(new PatientAppointment(2, "Bob", "08:00"));
        bst.addAppointment(new PatientAppointment(3, "Carol", "10:00"));

        List<String> times = new ArrayList<>();
        collectInOrderTimes(bst.getRoot(), times);

        assertEquals(List.of("08:00", "09:00", "10:00"), times);
    }

    @Test
    void testPreventDuplicateTimes() {
        AppointmentBST bst = new AppointmentBST();
        bst.addAppointment(new PatientAppointment(1, "Alice", "09:00"));
        bst.addAppointment(new PatientAppointment(2, "Duplicate", "09:00"));  // Duplicate

        List<String> times = new ArrayList<>();
        collectInOrderTimes(bst.getRoot(), times);

        assertEquals(1, times.size());
        assertEquals("09:00", times.get(0));
    }

    private void collectInOrderTimes(AppointmentNode node, List<String> times) {
        if (node != null) {
            collectInOrderTimes(node.left, times);
            times.add(node.data.appointmentTime);
            collectInOrderTimes(node.right, times);
        }
    }
}
