package OnlineMobileSearch;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

	public static WebDriver driver;

	public static WebDriver getDriver() {
		try {
			Scanner s = new Scanner(System.in);

			System.out.println("Enter browser name: ");

			String name = s.nextLine();

			if (name.equalsIgnoreCase("edge")) {

				System.setProperty("webdriver.edge.driver",
						"C:\\Users\\2317709\\eclipse-workspace\\SeleniumMiniProject\\Browser\\msedgedriver.exe");

				driver = new EdgeDriver();
				return driver;

			} else if (name.toLowerCase().contains("firefox")) {

				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\2317709\\eclipse-workspace\\SeleniumMiniProject\\Browser\\geckodriver.exe");

				driver = new FirefoxDriver();
				return driver;

			} else {

				System.out.println("Browser name is incorrect");

				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
