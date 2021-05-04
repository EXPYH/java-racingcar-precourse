package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarNameTest {
	@Test
	void carName_TooLongInput_ThrowIllegalArgumentException() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new CarName("tooLongName");
		});
	}

	@Test
	void carName_EmptyInput_ThrowIllegalArgumentException() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new CarName("");
		});
	}
}
