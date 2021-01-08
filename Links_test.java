package Mypack;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links_test{
    
    private static WebDriver driver = null;

    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\Documents\\chromedriver_win32\\chromedriver.exe");
        
        String home = ""
        		+ "";
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        
        driver= new ChromeDriver();
        
        driver.manage().window().maximize();
        
        driver.get(home);
        
        List<WebElement> link = driver.findElements(By.tagName("a"));
        System.out.println("Total no. of links are "
				+ link.size());
       
        Iterator<WebElement> it = link.iterator();
        
        while(it.hasNext()){
            
            url = it.next().getAttribute("href");
            
            System.out.println(url);
        
            if(url == null || url.isEmpty()){
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            
            /**if(!url.startsWith(home)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue; } **/
            
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }
                    
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
   
                e.printStackTrace();
            }
        }
        
        driver.quit();

    }
}