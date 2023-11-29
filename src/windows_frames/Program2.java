package windows_frames;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Program2 {
	
	@Test
	public void testSet() throws Exception {
				// Create a Driver instance
			
			WebDriver d= new ChromeDriver();
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			d.manage().deleteAllCookies();
	
			//Launch the URL
			d.get("http://the-internet.herokuapp.com/nested_frames");
			
			//Switching focus to top Frame
			WebElement topframe = d.findElement(By.xpath("//frame[@name='frame-top']"));
			d.switchTo().frame(topframe);
			
			// Get the number of frames in the middle frame
	        List<WebElement> frames = d.findElements(By.tagName("frame"));
	        int numberOfFrames = frames.size();
	        
	        System.out.println("Number of frames in the middle frame: " + numberOfFrames);
			
			//switch focus to left frame
			WebElement leftframe = d.findElement(By.name("frame-left"));
			d.switchTo().frame(leftframe);
			
			//System.out.println(d.findElement(By.name("frame")).getSize());
			//
			WebElement leftFrameMSG = d.findElement(By.xpath("//body[contains(.,'LEFT')]"));
			
			//Verify the Left frame has text "LEFT"
			assertEquals(leftFrameMSG.getText(),"LEFT");
			
			//Switch focus back to top frame from left frame
			d.switchTo().parentFrame();
			
			//Switching focus to Middle frame
			WebElement middleFrame = d.findElement(By.name("frame-middle"));
			d.switchTo().frame(middleFrame);
			
			//Locating the text 
			WebElement middleFrameMSG = d.findElement(By.id("content"));
			
			//Verify the middle frame has text "MIDDLE"
			assertEquals(middleFrameMSG.getText(),"MIDDLE");
			
			//Switch focus back to top frame from middle frame
			d.switchTo().parentFrame();
			
			//Switching focus to right frame
			WebElement rightFrame = d.findElement(By.name("frame-right"));
			d.switchTo().frame(rightFrame);
			
			//Locating the text in right frame
			WebElement rightFrameMSG = d.findElement(By.xpath("//body[contains(.,'RIGHT')]"));
			
			//Verify the right frame has text "RIGHT"
			assertEquals(rightFrameMSG.getText(),"RIGHT");
			
			//Switch focus back to top frame from right frame
			d.switchTo().parentFrame();
			
			//Switch focus back to main from top frame
			d.switchTo().parentFrame();
			
			//Switch focus to bottom frame
			WebElement bottomFrame = d.findElement(By.name("frame-bottom"));
			d.switchTo().frame(bottomFrame);
			
			//Locating the text in bottom frame
			WebElement bottomFrameMSG = d.findElement(By.xpath("//body[contains(.,'BOTTOM')]"));
			
			//Verify the right frame has text "RIGHT"
			assertEquals(bottomFrameMSG.getText(),"BOTTOM");
			
			//Switch focus back to top frame from bottom frame
			d.switchTo().parentFrame();
			
			//switch back to top frame
			d.switchTo().frame(topframe);
			
			//Verify the page title
			//assertEquals(d.getTitle(),"");
			
			Thread.sleep(2000);
			
			//Close the browser
			d.quit();
	}
}

