import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Calculator {
	int add(int a, int b) {
		return a + b;
	}
}

public class CalculatorTest {
	@Test
	void testAdd() {
		Calculator calc = new Calculator();
		assertEquals(5, calc.add(2, 3));
	}
}