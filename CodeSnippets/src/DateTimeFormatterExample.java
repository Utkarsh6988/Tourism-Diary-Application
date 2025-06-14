import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class DateTimeFormatterExample {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2023, 7, 25);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(date.format(formatter));
	}
}
