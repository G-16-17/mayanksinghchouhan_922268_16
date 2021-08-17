package Mainpack;

public class CarFactoryProvider {

	public static Factory createCar(String carName) {
		if (carName.equalsIgnoreCase("Audi"))
			return new AudiFactory();
		else if (carName.equalsIgnoreCase("Mercedes"))
			return new MercedesFactory();
		else
			return null;
	}
}
