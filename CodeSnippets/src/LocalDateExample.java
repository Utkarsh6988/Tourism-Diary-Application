import java.time.LocalDate;

public class LocalDateExample {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2020, 5, 10);
		System.out.println(date.getDayOfWeek());
	}
}