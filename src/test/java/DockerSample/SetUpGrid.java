package DockerSample;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SetUpGrid {
	
	@BeforeTest
	public void startGrid() throws Exception
	{
		Runtime.getRuntime().exec("cmd /c start Start_Docker.bat");
		Thread.sleep(15000);
	}
	@AfterTest
	public void stopGrid() throws Exception
	{
		Runtime.getRuntime().exec("cmd /c start Stop_Docker.bat");
		Thread.sleep(6000);
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
		
	}

}
