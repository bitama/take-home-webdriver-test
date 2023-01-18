package draganddrop;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {

	static String url = "http://localhost:7080/drag_and_drop";
	static  WebDriver driver;
    @BeforeTest
	public static void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
    @Test
    public void dragAndDrop(){
    	WebElement source=driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
    	WebElement destination=driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
    	
    	
    	
    	Actions actions=new Actions(driver);
    	
//    	Actions dragAndDrop=actions.clickAndHold(source)
//    			.moveToElement(destination).release(destination);
//    	dragAndDrop.build().perform();
    	actions.dragAndDrop(source,destination).perform();
    	
		

		
	}
//     @AfterTest
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	

}
