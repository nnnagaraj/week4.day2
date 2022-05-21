package week4.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {

		// Listbox/Dropdown

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the URL "http://www.leafground.com/pages/Dropdown.html"
		driver.get("http://www.leafground.com/pages/Dropdown.html");

		// Select training program using Index
		WebElement dropDown1 = driver.findElement(By.id("dropdown1"));
		Select select1 = new Select(dropDown1);
		select1.selectByIndex(1);

		// Select training program using Text
		WebElement dropDown2 = driver.findElement(By.name("dropdown2"));
		Select select2 = new Select(dropDown2);
		select2.selectByVisibleText("Appium");

		// Select training program using Value
		WebElement dropDown3 = driver.findElement(By.name("dropdown3"));
		Select select3 = new Select(dropDown3);
		select3.selectByValue("1");

		// Get the number of dropdown options
		WebElement dropDown4 = driver.findElement(By.className("dropdown"));
		Select select4 = new Select(dropDown4);
		List<WebElement> options = select4.getOptions();
		System.out.println("Number of dropdown options: " + options.size());
		for (WebElement eachoptions : options) {
			System.out.println("Print thr options in dropdown 5 " + eachoptions.getText());
		}

		// Use sendkeys to select the options
		driver.findElement(By.xpath("(//div[@class='example'])[5]//select")).sendKeys("Loadrunner");

		// Select mulitple options
		WebElement dropdown6 = driver.findElement(By.xpath("(//div[@class='example'])[6]//select"));
		Select select6 = new Select(dropdown6);
		select6.selectByIndex(1);
		select6.selectByIndex(2);

		//Thread.sleep(2000);
		driver.close();

	}

}
