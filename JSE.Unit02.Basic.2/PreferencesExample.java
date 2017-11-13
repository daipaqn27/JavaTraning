package unit02;

import java.util.prefs.Preferences;

public class PreferencesExample {
	public static void main(String[] args) {
		Preferences preferences = 
				Preferences.userNodeForPackage(PreferencesExample.class);
		System.out.println("old value: " + preferences.get("data1", "no value"));
		
		preferences.put("data1", "system " + System.currentTimeMillis());
		
		System.out.println("new value: " + preferences.get("data1", "no value"));
	}
}
