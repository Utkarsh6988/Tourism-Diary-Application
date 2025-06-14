import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {
	@Test
	void testException() {
		assertThrows(ArithmeticException.class, () -> {
			int a = 1 / 0;
		});
	}
}