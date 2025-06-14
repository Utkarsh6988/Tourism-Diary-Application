import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BooleanTest {
	@Test
	void testBoolean() {
		assertTrue(5 > 3);
		assertFalse(2 > 4);
	}
}