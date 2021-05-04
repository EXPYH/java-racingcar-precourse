package logic;

import static constants.RacingConst.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class InputValidator {
	public boolean isValidCarNamesInput(List<String> input) {
		try {
			String maxLenStr = Collections.max(input, String::compareTo);
			String minLenStr = Collections.min(input, String::compareTo);
			return !minLenStr.isEmpty() && maxLenStr.length() <= NAME_MAX_LENGTH && !hasDuplicate(input);
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean hasDuplicate(List<String> inputList) {
		Set<String> inputSet = new HashSet<>(inputList);
		return inputSet.size() < inputList.size();
	}

	public boolean isValidCount(String input) {
		try {
			return Integer.parseInt(input) > 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
