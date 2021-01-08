package Mypack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Search {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\Documents\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://dlc.dwit.edu.np/");
		 
		driver.manage().window().maximize();
		
		
		driver.findElement(By.id("searchTerm")).sendKeys("force");
		Thread.sleep(10000);
		
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='suggestions']//select[@name='states[]']\r\n" + 
				""));
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++)
		{
			String listitem=list.get(i).getText();
			
			System.out.println(listitem);
			if(listitem.contains("FORCE - GRAVITY"))
			{
				list.get(i).click();
				break;
			}
		}
		
		WebElement button = driver.findElement(By.id("ytp-large-play-button ytp-button"));
		button.click();
	}
}
