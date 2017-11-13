package unit02;

import java.util.Calendar;
import java.util.Locale;

public class VIDU2 {
	String getTypeOfDay(Calendar calendar){
		String type = calendar.getDisplayName(
				Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("vi"));
		switch(type){
			case "Th 2":
				return "Start of week";
			case "Th 3":
			case "Th 4":
				return "MidWeek";
			case "Th 5":
			case "Th 6":
				return "End of work week";
			case "Th 7":
			case "CN":
				return "Weekend";
		}
		return "Unknown";
		
	}
	public static void main(String[] args) {
		VIDU2 vidu2 = new VIDU2();
		Calendar calendar = Calendar.getInstance();
		System.out.println("Today is: " +  vidu2.getTypeOfDay(calendar));
		
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
		System.out.println("Tomorow: " + vidu2.getTypeOfDay(calendar));
	}
}
