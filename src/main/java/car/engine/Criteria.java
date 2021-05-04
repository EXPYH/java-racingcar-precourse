package car.engine;

public class Criteria {
	private final int  value;

	public Criteria(int value) {
		if (value <= 0){
			throw new IllegalArgumentException();
		}
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
