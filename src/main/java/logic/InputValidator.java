package logic;

import static constants.RacingConst.*;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class InputValidator {
	public boolean isValidCarNamesInput(List<String> input) {
		try {
			String maxLenStr = Collections.max(input, String::compareTo);
			String minLenStr = Collections.min(input, String::compareTo);
			return !minLenStr.isEmpty() && maxLenStr.length() <= NAME_MAX_LENGTH;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isValidCount(String input) {
		try {
			return Integer.parseInt(input) > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
