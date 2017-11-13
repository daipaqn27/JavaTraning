package unit02;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class vidu1 {
	
	public static void main(String[] args) {
		Locale locale = new Locale("vi", "VN");
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE, dd/MM/yyyy",locale);
		Calendar calendar = Calendar.getInstance();
		System.out.println(dateFormat.format(calendar.getTime()));
	}
}
