package windows_frames;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Program1 {
	
	@Test
	public void testSet() throws Exception {
				// Launch a browser
			WebDriver d= new ChromeDriver();
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			d.manage().deleteAllCookies();
	
			// Launch the URL
			d.get("https://the-internet.herokuapp.com/iframe");
			
			//Switching focus into iframe 
			WebElement frameinside = d.findElement(By.xpath("//iframe[@title='Rich Text Area']"));
			d.switchTo().frame(frameinside);
			
			//Locate the text field
			WebElement textField = d.findElement(By.xpath("//p"));
			//Clear the existing text
			textField.clear();
			//Enter the text
			textField.sendKeys("Hello People");
			
			Thread.sleep(2000);
			
			//Close the browser
			d.quit();
	}
}

