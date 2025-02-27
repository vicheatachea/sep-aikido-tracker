import org.example.AikidoTracker;
import org.example.AikidoTrackerMain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AikidoTrackerTest {

    private AikidoTracker tracker;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUp() {
        tracker = new AikidoTracker();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAddSession() {
        tracker.addSession(LocalDate.of(2023, 1, 1), 60);
        assertEquals(1, tracker.getSessions().size());

        String input = "1\n2023-01-01\n60\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        AikidoTrackerMain.run(tracker, scanner);

        assertTrue(outContent.toString().contains("Session added."));
        assertEquals(2, tracker.getSessions().size());
    }
}