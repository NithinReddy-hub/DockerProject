package DockerSample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	
    public String baseUrl="http://demo.guru99.com/test/newtours/";
   
    public RemoteWebDriver driver;
    public URL url;
     //creating test annotations

     @BeforeClass
      public void launchBrowser()  {
    	 try{
          System.out.println("launching chrome browser");
          DesiredCapabilities caps=DesiredCapabilities.chrome();
          url=new URL("http://localhost:4444/wd/hub");
	      driver=new RemoteWebDriver(url,caps);
	      driver.get(baseUrl);
	      
    	 }catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
        
     }
      @Test
      public void verifyHomepageTitle() {
    	
         // String expectedTitle = "Welcome: Mercury Tours";
          String actualTitle = driver.getTitle();
          System.out.println(actualTitle);
          //Assert.assertEquals(actualTitle, expectedTitle);
     }
    
      @AfterClass
      public void terminateBrowser(){
          driver.close();
      }
	
}