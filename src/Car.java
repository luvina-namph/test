/**
 * class car test
 */
public class Car {
	private String name;
	private Boolean canWorking = false; // dung wapper thay vi primative
	/** VIN Vehicle Identification Number */
	private String identificationNumber;

	public Car() {}

	/**
	 * constructor define new car
	 * @param name name of car
	 * @param canWorking state working of car, true if working, false if not working
	 */
	public Car(String name, Boolean canWorking, String identificationNumber) {
		this.name = name;
		this.canWorking = canWorking;
		this.identificationNumber = identificationNumber;
	}

	// ko co java doc dau method
	// function ko duoc dung o dau ca
	public String stateOfCar() {
		return TestRule.AAA;
	}

	// getter / setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getCanWorking() {
		return canWorking;
	}
	public void setCanWorking(Boolean canWorking) {
		this.canWorking = canWorking;
	}
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
}
