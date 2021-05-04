package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DistanceTest {

	@Test
	void distance_NonPositiveArgument_ThrowIllegalArgumentException() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Distance(-1);
		});
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 5, 7, 23})
	void getCurrentDistanceStr_MovedCarInputs_CorrectString(int movedDistance) {
		Distance distance = new Distance(movedDistance);
		StringBuilder expected = new StringBuilder();
		for (int i = 0; i < movedDistance; ++i) {
			expected.append("-");
		}
		assertThat(distance.getCurrentDistanceStr()).isEqualTo(expected.toString());
	}
}
