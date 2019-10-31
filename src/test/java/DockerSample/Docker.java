package DockerSample;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Docker {
	
    public String baseUrl="https://docs.docker.com/docker-for-windows/";
   
    public RemoteWebDriver driver;
    public URL url;
     //creating test annotations

     @BeforeTest
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
    
      @AfterTest
      public void terminateBrowser(){
          driver.close();
      }
	
}
