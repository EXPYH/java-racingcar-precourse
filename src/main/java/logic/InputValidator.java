package logic;

import java.util.Collections;
import java.util.List;

public class InputValidator {
	public boolean isValidCarNamesInput(List<String> input) {
		String maxLenStr = Collections.max(input, String::compareTo);
		String minLenStr = Collections.min(input, String::compareTo);
		return !minLenStr.isEmpty() && maxLenStr.length()<=5;
	}

	public boolean isValidCount(String input) {
		try{
			return Integer.parseInt(input) > 0;
		} catch(NumberFormatException e){
			return false;
		}
	}
}
