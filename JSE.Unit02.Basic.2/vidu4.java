package unit02;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class vidu4 {
 public static void main(String[] args) {
	 SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE, dd/MM/yyyy", new Locale("vi"));
	String message = MessageFormat.format("Hello {0}", dateFormat.format(Calendar.getInstance().getTime()));
	System.out.println(message);
}
}
