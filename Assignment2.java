package week4.day2;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		// Launch the URL http://www.leafground.com/pages/Window.html
		driver.get("http://www.leafground.com/pages/Window.html");

		// Get the Title of current page
		System.out.println(driver.getTitle());

		// Click button to open home page in New Window
		driver.findElement(By.id("home")).click();

		// Switch to new window and get the title of new page
		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> newWindowHandlesList1 = new ArrayList(windowHandles1);
		String newWindowHandles1 = newWindowHandlesList1.get(1);
		driver.switchTo().window(newWindowHandles1);
		System.out.println(driver.getTitle());

       //Switch back to old window and get the title of old window
		String oldWindowHandles1 = newWindowHandlesList1.get(0);
		driver.switchTo().window(oldWindowHandles1);
		System.out.println("parent window: " + driver.getTitle());

		// Click 'Open multiple window' button and find the number of opened windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		ArrayList<String> newWindowHandlesList2 = new ArrayList(windowHandles2);
		System.out.println("Number of opened windows : " + newWindowHandlesList2.size());

		// Click 'Do not close me' button and close all the windows except this window
		driver.findElement(By.xpath("//button[contains(text(),'not close me')]")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		ArrayList<String> newWindowHandlesList3 = new ArrayList(windowHandles3);
		System.out.println("Number of opened windows of donot close me button : " + newWindowHandlesList3.size());
		for (int i = 1; i < newWindowHandlesList3.size(); i++) {
			driver.switchTo().window(newWindowHandlesList3.get(i));
			driver.close();
		}

		// switch to old window and get the title
		driver.switchTo().window(newWindowHandlesList3.get(0));
		System.out.println("last window" + driver.getTitle());

		// Click 'wait for 5 seconds' button and wait for 5 seconds 2 new Windows to open		
		driver.findElement(By.xpath("//button[contains(text(),'Wait for 5 second')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //find the number of opened windows
		Set<String> windowHandles4 = driver.getWindowHandles();
		ArrayList<String> newWindowHandlesList4 = new ArrayList(windowHandles4);
		System.out.println("Number of opened windows : " + newWindowHandlesList4.size());

		// switch to each windows and get the title of each window
		for (int i = 1; i < newWindowHandlesList4.size(); i++) {
			driver.switchTo().window(newWindowHandlesList4.get(i));
			System.out.println("title of window" + (i) + ":" + driver.getTitle());
			driver.close();
		}

        //Switch back to old window
		driver.switchTo().window(newWindowHandlesList4.get(0));

		// close the browser
		driver.close();

	}
}
