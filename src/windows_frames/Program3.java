package windows_frames;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Program3 {
	@Test
	public void testSet() throws Exception {
		// Create a new instance of the Chrome driver
			WebDriver d= new ChromeDriver();
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			d.manage().deleteAllCookies();
	
			// Launch the URL
			d.get("https://the-internet.herokuapp.com/windows");
			
			//verify the page The Internet
			assertEquals(d.getTitle(),"The Internet");
			
			//Click on "Click Here" option
			WebElement clickHere = d.findElement(By.linkText("Click Here"));
			clickHere.click();
			
			Thread.sleep(3000);
			
			// Get the window handles of the current session
	        Set<String> windowHandles = d.getWindowHandles();
			//switching focus to the new window
			
	        for (String windowHandle : windowHandles) {
	            d.switchTo().window(windowHandle);
	        }
			//Verify the text 
	        assertEquals(d.findElement(By.xpath("//h3")).getText(),"New Window");
	        
			//verify the page The Internet
			assertEquals(d.getTitle(),"New Window");
			Thread.sleep(2000);
			
			// Close the new window
			d.close();	
			
			Thread.sleep(2000);
			
			// Switch back to the original window
	        d.switchTo().window(windowHandles.iterator().next());
	        
	        //Verify the page
	        assertEquals(d.getTitle(),"The Internet");
			
			//Close the browser
			d.quit();
	}

}