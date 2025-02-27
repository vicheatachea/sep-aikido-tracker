import org.example.AikidoTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AikidoTrackerTest {

    private AikidoTracker tracker;

    @BeforeEach
    public void setUp() {
        tracker = new AikidoTracker();
    }

    @Test
    public void testAddSession() {
        tracker.addSession(LocalDate.of(2023, 1, 1), 60);
        assertEquals(1, tracker.getSessions().size());
    }

    @Test
    public void testGetTotalTrainingTime() {
        tracker.addSession(LocalDate.of(2023, 1, 1), 60);
        tracker.addSession(LocalDate.of(2023, 1, 2), 90);
        assertEquals(150, tracker.getTotalTrainingTime());
    }

    @Test
    public void testIsEligibleForKyu() {
        for (int i = 0; i < 100; i++) {
            tracker.addSession(LocalDate.of(2023, 1, 1).plusDays(i), 60);
        }
        assertTrue(tracker.isEligibleForKyu(LocalDate.now()));

        tracker = new AikidoTracker();
        tracker.addSession(LocalDate.of(2023, 1, 1), 60);
        tracker.addSession(LocalDate.of(2023, 7, 1), 60);
        assertTrue(tracker.isEligibleForKyu(LocalDate.now()));

        tracker = new AikidoTracker();
        tracker.addSession(LocalDate.of(2023, 1, 1), 60);

        LocalDate fixedCurrentDate = LocalDate.of(2023, 5, 1);
        assertFalse(tracker.isEligibleForKyu(fixedCurrentDate));
    }
}