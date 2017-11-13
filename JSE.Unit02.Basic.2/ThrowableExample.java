package unit02;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThrowableExample {
	static int toNumber(String value) throws SaiSoException{
		try {
			Integer integer = Integer.parseInt(value);
			return integer.intValue();
		} catch (NumberFormatException e) {
			throw new SaiSoException(value);
		}
	}
	private final static Logger LOGGER = 
			Logger.getLogger(ThrowableExample.class.getName());
	public static void main(String[] args) {
		String value = "p";
		try {
			System.out.println("number = " + toNumber(value));
		} catch (SaiSoException e) {
			System.out.println(e.getMessage());
			LOGGER.log(Level.WARNING,e.getMessage());
		}
	}
}
