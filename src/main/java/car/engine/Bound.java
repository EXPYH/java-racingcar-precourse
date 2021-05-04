package car.engine;

public class Bound {
	private final int value;

	public Bound(int value) {
		if (value <= 0) {
			throw new IllegalArgumentException();
		}
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
