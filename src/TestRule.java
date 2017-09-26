import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestRule {
	public static final String AAA = "Xe bo"; // ten ko co y nghia, hang so ko duoc comment java doc
	/** State vehicle is good for working */
	public static final String WORKING = "Chay Ngon";

	public static void main(String[] args) {

		//Start fix #1234 by ABC, 2017/04/13
		Car fordExplorer = new Car("Ford Explorer", Boolean.TRUE, "USA121h123123h");
		// Car kiaMorning = new Car("Ford Explorer", Boolean.TRUE, "121h123123h");
		//End fix #1234 by ABC, 2017/04/13
		Car kiaMorning1 = new Car("Kia Morning", true, "KRA222U333t444");
		Car kiaMorning2 = new Car("Kia Morning", false, "KRA222U333t444");

		Car vinaXuki1 = new Car("Vina Xuki", false, "VNAXuki@#123%4");
		Car vinaXuki2 = new Car("Vina Xuki", true, "VNAXuki@#123%4");
		Car hoWo = new Car("HoWo", false, "CHI@#123%4");

		/*Car vinaXuki1 = new Car("Vina Xuki", false, "VNAXuki1234567894");
		Car vinaXuki2 = new Car("Vina Xuki", true, "VNAXuki1234561324");
		Car hoWo = new Car("HoWo", false, "CHI1231231231234");*/

		// Khoi tao mac dinh Capacity = 0
		Set<Car> carSet = new HashSet<Car>(0);
		carSet.add(fordExplorer);
		carSet.add(kiaMorning1);
		carSet.add(kiaMorning2);
		carSet.add(vinaXuki1);
		carSet.add(vinaXuki2);
		carSet.add(hoWo);

		if(timXe(carSet))
			System.out.println("\n Mua de");

	}

	// ko co java doc dau method
	// Cyclomatic Complexity > 10
	public static boolean timXe (Set<Car> carSet) {
		// Dung Wapper thay vi primative
		// Dat ten bien sai
		Boolean ahaha = false;

		for (Car car : carSet) {
			// thread-safe ko constant
			Pattern asciiPattern = Pattern.compile("^\\p{ASCII}*$"); // ASCII
			Matcher match = asciiPattern.matcher(car.getIdentificationNumber());
			if (match.find()) {

				// So 0, 3 ko the hien duoc y nghia.
				String certificateOrigin = car.getIdentificationNumber().substring(0, 3).equals("KRA") ? "Han Quoc"
						: car.getIdentificationNumber().substring(0, 3).equals("USA") ? "My nhe" : "Ko quan tam";
				// Thua tham so length
				String identificationNumber = car.getIdentificationNumber().substring(3, car.getIdentificationNumber().length());

				// Hang so dat ben trai khi so sanh voi bien so
				if("HoWo".equals(car.getName())) {
					System.out.println("\n" + car.getName() + " --> Danh sach loi roi, ko choi xe tai nhe");
					ahaha = false;
					return ahaha;
				// return o tren thi doan nay ko can else
				} else {
					if ("Vina Xuki".equals(car.getName())) {
						// qua 3 lan if else
						if (false == car.getCanWorking()) {
							System.out.println("\n" + car.getName() + ", " + AAA + " --> Xe vua lom vua hong, Ko mua.");
							ahaha = false;
						}
					}
				}

				// Co the gop 2 if vao thanh 1
				if ("Vina Xuki".equals(car.getName())) { // Hang so dat ben trai khi so sanh voi bien so
					if (car.getCanWorking()) {
						System.out.println("\n" + car.getName() + ", " + WORKING + " --> Xe nay mua di tam.");
						System.out.println("\n Xe nay cua nuoc :" + certificateOrigin);
						System.out.println("\n So khung la :" + identificationNumber);
						ahaha = true;
					}
				}

				// So sanh bien kieu boolean vowi true false
				if (car.getName().equals("Kia Morning") && false == car.getCanWorking()) {
					System.out.println("\n" + car.getName() + ", " + AAA + " --> Xe nay mua ve phai sua.");
					ahaha = false;
				}

				if (car.getName().equals("Kia Morning") && car.getCanWorking()) {
					System.out.println("\n" + car.getName() + ", " + WORKING + " --> Xe nay mua cung duoc.");
					System.out.println("\n Xe nay cua nuoc :" + certificateOrigin);
					System.out.println("\n So khung la :" + identificationNumber);
					ahaha = true;
				}

				// if nhieu hon 3 dieu kien check
				if(!car.getName().equals("HoWo") && !car.getName().equals("Vina Xuki") && !car.getName().equals("Kia Morning")
						&& car.getName().equals("Ford Explorer") && car.getCanWorking() == true) {
					System.out.println("\n" + car.getName() + ", " + WORKING +  " --> Xe ngon mua gap");
					System.out.println("\n Xe nay cua nuoc :" + certificateOrigin);
					System.out.println("\n So khung la :" + identificationNumber);
					ahaha = true;
					return ahaha;
				}
			} else {
				System.out.println("\n" + car.getName() + "la hang gia");
				return ahaha;
			}
		}
		return ahaha;
	}

}