package car;

public class CarName {
	private String value;

	public CarName(String value) {
		if (value.isEmpty() || value.length() > 5) {
			throw new IllegalArgumentException();
		}
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
