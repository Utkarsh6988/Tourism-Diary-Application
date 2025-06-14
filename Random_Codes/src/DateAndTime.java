
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

import java.time.*;
import java.time.format.*;

public class  DateAndTime {
    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        
        // Convert to IST (UTC+5:30)
        ZoneId istZone = ZoneId.of("Asia/Kolkata");
        ZonedDateTime istTime = zonedDateTime.withZoneSameInstant(istZone);
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        String formattedIST= istTime.format(dateTimeFormatter);
        
        System.out.println("Current Date: " + currentDate.format(dateFormatter));
        System.out.println("Current Time: " + currentTime.format(timeFormatter));
        System.out.println("Date and Time: " + currentDateTime.format(dateTimeFormatter));
        System.out.println("With Timezone: " + formattedIST);
        
 
    }
}