package logic;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

	private static InputValidator inputValidator;

	@BeforeAll()
	public static void beforeAll(){
		inputValidator = new InputValidator();
	}

	@Test
	void isValidCarNamesInput_TooLongInput_False(){
		List<String> cars = new ArrayList<>(Arrays.asList("abcdefg", "abc"));
		assertThat(inputValidator.isValidCarNamesInput(cars)).isFalse();
	}

	@Test
	void isValidCarNamesInput_EmptyInput_False(){
		List<String> cars = new ArrayList<>();
		cars.add("");
		assertThat(inputValidator.isValidCarNamesInput(cars)).isFalse();
	}

	@Test
	void isValidCarNamesInput_ValidInput_True(){
		List<String> cars = new ArrayList<>(Arrays.asList("James", "Henry", "Kitty"));
		assertThat(inputValidator.isValidCarNamesInput(cars)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"three", "2hundreds", "1,000,000", "0", "-1"})
	void isValidCount_NonIntegerInput_False(){
		String input = "test";
		assertThat(inputValidator.isValidCount(input)).isFalse();
	}

	@Test
	void isValidCount_EmptyInput_False(){
		String input = "";
		assertThat(inputValidator.isValidCount(input)).isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "29", "10000"})
	void isValidCount_ValidInput_True(String input){
		assertThat(inputValidator.isValidCount(input)).isTrue();
	}
}
