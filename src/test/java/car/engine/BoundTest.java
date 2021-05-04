package car.engine;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BoundTest {
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, -999})
	void criteria_NonPositiveArgument_ThrowIllegalArgumentException(int input) {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Criteria(input);
		});
	}
}
