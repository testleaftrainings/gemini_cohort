package Sprint1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDates {
	
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		String format = today.plusDays(1).format(DateTimeFormatter.ISO_DATE);
		
		String[] split = format.split("-");
		String date = split[2];
		String trim = date.trim();
		System.out.println(format);
		System.out.println(date);
	}

}
