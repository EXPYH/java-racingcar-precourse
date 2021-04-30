package car;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class CarListTest {
	@Test
	void getWinners_JointFirst_ReturnMultipleCar(){
		Car henry = new Car(new CarName("Henry"), new Distance(10));
		Car jerry = new Car(new CarName("Jerry"), new Distance(8));;
		Car marry = new Car(new CarName("Mary"), new Distance(10));
		List<Car> cars = new ArrayList<>(Arrays.asList(henry, jerry, marry));
		List<Car> expected = new ArrayList<>(Arrays.asList(henry, marry));
		assertThat(new CarList(cars).getWinners()).isEqualTo(expected);
	}

	@Test
	void getWinners_OnlyOneFirst_ReturnMultipleCar(){
		Car henry = new Car(new CarName("Henry"), new Distance(10));
		Car jerry = new Car(new CarName("Jerry"), new Distance(12));;
		Car marry = new Car(new CarName("Mary"), new Distance(10));
		List<Car> cars = new ArrayList<>(Arrays.asList(henry, jerry, marry));
		List<Car> expected = new ArrayList<>(Arrays.asList(jerry));
		assertThat(new CarList(cars).getWinners()).isEqualTo(expected);
	}
}
