package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//maximize the window
		driver.manage().window().maximize();

		// Enter UserName and Password Using ID locator
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.xpath("//div[@for='crmsfa']")).click();

		// Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		// Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		// Get the title and URL of current window
		System.out.println("Parent window title : " + driver.getTitle());
		System.out.println("Parent window URL : " + driver.getCurrentUrl());
		
		//print ----------
		System.out.println("----------------------------------------");

        //Click on Widget of From Contact
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();

		// Switch to new window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> newWindowhandleList = new ArrayList(windowHandles);
		String newWindowhandles = newWindowhandleList.get(1);
		driver.switchTo().window(newWindowhandles);

		// Get the title and URL of new window
		System.out.println("Find contacts window title (from contact) : " + driver.getTitle());
		System.out.println("Find contacts window URL(from contact) : " + driver.getCurrentUrl());
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on First Resulting Contact
		WebElement table1 = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]"));
		List<WebElement> rows1 = table1.findElements(By.tagName("tr"));
		List<WebElement> columns1 = rows1.get(0).findElements(By.tagName("td"));
		System.out.println(columns1.get(0).getText());
		columns1.get(0).click();

		// navigate to parent/old window
		String oldWindowhandles = newWindowhandleList.get(0);
		driver.switchTo().window(oldWindowhandles);

		// Click on Widget of To Contact
		driver.findElement(By.id("ComboBox_partyIdTo")).sendKeys(Keys.TAB, Keys.ENTER);
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> newWindowhandleList1 = new ArrayList(windowHandles1);

		// switch to new window
		String newWindowhandles1 = newWindowhandleList1.get(1);
		driver.switchTo().window(newWindowhandles1);
		
		// Get the title and URL of new window
		System.out.println("Find contacts window title (To contact) : " + driver.getTitle());
		System.out.println("Find contacts window URL(To contact) : " + driver.getCurrentUrl());

		// Click on Second Resulting Contact
		WebElement table2 = driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]"));
		List<WebElement> rows2 = table2.findElements(By.tagName("tr"));
		List<WebElement> columns2 = rows2.get(0).findElements(By.tagName("td"));
		System.out.println(columns2.get(0).getText());
		columns2.get(0).click();

		// switch to parent/prev. window
		String oldWindowhandles1 = newWindowhandleList.get(0);
		driver.switchTo().window(oldWindowhandles1);

		// Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Accept the Alert
		driver.switchTo().alert().accept();

		// verify the title of the page
		System.out.println(driver.getTitle());

		//Close the browser
		driver.close();

	}

}
