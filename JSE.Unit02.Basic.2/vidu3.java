package unit02;

import java.util.Calendar;
import java.util.Locale;

public class vidu3 {
	public enum VnDay{
		THU_HAI, THU_BA, CHU_NHAT, KHONG_BIET;
		static VnDay valueOf(Calendar calendar){
			String type = calendar.getDisplayName(
					Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("vi"));
			switch(type){
				case "Th 2":
					return THU_HAI;
				case "Th 3":
					return THU_BA;
				case "CN":
					return CHU_NHAT;
			}
			return KHONG_BIET;
		}
	}
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(VnDay.valueOf(calendar));
	}
}