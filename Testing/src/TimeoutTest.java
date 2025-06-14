import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TimeoutTest {
	@Test
	void testTimeout() {
		assertTimeout(java.time.Duration.ofMillis(100), () -> {
			Thread.sleep(50);
		});
	}
}


//The test starts and begins timing the execution
//
//The Thread.sleep(50) makes the thread pause for 50 milliseconds
//
//The assertTimeout checks if the entire block completes within 100ms
//
//Since 50ms < 100ms, the test passes