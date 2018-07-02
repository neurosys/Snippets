import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateAndTime {
	
	public static void printDateAndTime() {
		LocalDate localDate = LocalDate.now();
		int dayofYear = localDate.getDayOfYear();
		int dayOfMonth = localDate.getDayOfMonth();
		int dayOfWeek = localDate.getDayOfWeek().getValue(); 
		int month = localDate.getMonthValue();
		int year = localDate.getYear();
		
		LocalDateTime localDateTime = LocalDateTime.now();
		int hour = localDateTime.getHour();
		int minutes = localDateTime.getMinute();
		int seconds = localDateTime.getSecond();
		int nanoseconds = localDateTime.getNano();
		
		System.out.println(localDate.toString());
		System.out.println(localDateTime.toString());
		System.out.println(LocalTime.now().toString());
		System.out.println("unix timestamp = (ms) " + Instant.now().toEpochMilli());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_kk-mm-ss:SSS");
		System.out.println("Printed with my format: " + localDateTime.format(formatter));
	}
	
	public static void parseDefaultTimestampFormat() {
		System.out.println("-------------------------------------------");
		System.out.println("Parse the default format of LocalDateTime");
		
		LocalDateTime ldt = LocalDateTime.now();
		String timeString = ldt.toString();
		System.out.println("> " + timeString);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'kk:mm:ss.SSS");
		LocalDateTime newldt = LocalDateTime.parse(timeString, formatter);
		System.out.println("< " + newldt);
	}

	public static void main(String[] args) {
		printDateAndTime();
		
		String myTimestamp = "2018-06-30_11-30-24:443";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_kk-mm-ss:SSS");
		LocalDateTime ldt = LocalDateTime.parse(myTimestamp, formatter);
		System.out.println("Parsed timestamp = " + ldt.toString());
		
		parseDefaultTimestampFormat();
	}

}
