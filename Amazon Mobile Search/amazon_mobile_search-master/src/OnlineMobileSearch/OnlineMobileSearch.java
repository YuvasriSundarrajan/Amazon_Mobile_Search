package OnlineMobileSearch;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OnlineMobileSearch {
	static WebDriver driver;

	public WebDriver setup() {
		driver = DriverSetup.getDriver();
		return driver;
	}

	public String getUrl() {
		try {
			// Navigate to the URL "https://www.amazon.in"
			String baseUrl = "https://www.amazon.in";
			driver.get(baseUrl);
			
			// Maximize the Window
			driver.manage().window().maximize();
			// Implicit Wait
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("The URL of Web Application is : " + driver.getCurrentUrl());
			System.out.println("The Title of Web Application is : " + driver.getTitle());
			return baseUrl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void searchTextBox() {
		WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchTextBox.sendKeys("mobile smartphones under 30000");
		System.out.println("The search text is : " + searchTextBox.getAttribute("value"));
		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		searchButton.click();
		// searchTextBox.submit()

	}

	public void resultMessage() {
		WebElement parentElement = driver
				.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

		// Extract page range and item count

		String pageInfo = parentElement.getText();

		String[] pageInfoParts = pageInfo.split(" of over ");

		String itemCount = pageInfoParts[1].split(" ")[0];

		System.out.println("Number of Pages: " + pageInfoParts[0]);
		System.out.println("Number of Items: " + itemCount);
	}

	public void sortBy() {
		// Locate the "Sort By" list box and click on it
		WebElement listBox = driver.findElement(By.className("a-dropdown-label"));
		listBox.click();
		System.out.println("The List Box is: " + listBox.getText());

		// Locate the options of Select class of list box
		WebElement sortBy = driver.findElement(By.xpath("//*[@id=\"s-result-sort-select\"]"));
		System.out.println("The options in the List Box are : " + sortBy.getText());
		

		// Find total count of options in list box
		Select option = new Select(sortBy);
		List<WebElement> list = option.getOptions();
		System.out.println("The count of List Box options is: " + list.size());

	}

	public void newestArival() {
		WebElement opt = driver.findElement(By.id("s-result-sort-select_4"));
		System.out.println("Selected option : " + opt.getText());
		opt.click();

		// Verify that the Newest Arrivals option got selected correctly or not
		if (opt.isEnabled()) {
			System.out.println("The Newest Arrivals option is selected correctly");
		} else {
			System.out.println("The Newest Arrivals option not selected correctly");
		}
	}

	public static void main(String args[]) {
		OnlineMobileSearch search = new OnlineMobileSearch();
		search.setup();
		search.getUrl();
		search.searchTextBox();
		search.resultMessage();
		search.sortBy();
		search.newestArival();
        driver.close();
	}
}
