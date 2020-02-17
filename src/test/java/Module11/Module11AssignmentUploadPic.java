package Module11;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
/*Create a maven project to upload your photo on edureka portal using maven frameworks.
 * Configure the same with Jenkins to run the test every day. 
 * Steps:Create a Maven project
 *  and perform the below steps:
 *  1.Launch edureka portal on the browser.
 *  2.Login with the credentials 
 *  3.Navigate to edit profile page
 *  4.Edit uploading photo button
 *  5.Integrate with jenkins to rerun the testcase daily
 *  Note:Make sure that you are logged out of Edureka’s website while performing this practical
 */

public class Module11AssignmentUploadPic {
	
	WebDriver driver;
@BeforeSuite
public void OpenBrowser()
{
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
	 driver = new ChromeDriver();
}

@AfterSuite
public void CloseBrowser()
{
driver.close();	
}

@Test(priority =0)
public void OpenAUT()
{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.get("http://www.edureka.co/");
	driver.manage().window().maximize();
}

@Test(priority=1)
public void LogIn() throws InterruptedException
{
	driver.findElement(By.xpath("//a[@data-gi-action=\"Login\" and contains(text(),'Log In')]") ).click();
	Thread.sleep(2000);
	
	driver.findElement(By.id("si_popup_email")).sendKeys("vinitbassi@gmail.com");

	driver.findElement(By.id("si_popup_passwd")).sendKeys("India15Great");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[text()='Login']")).click();
	
}
@Test(priority=2)
public void ClickProfile() throws InterruptedException
{
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[@class=\"dropdown-toggle\"])[5]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//li[@role=\"menuitem\"]//a[text()='My Profile']")).click();
}
@Test(priority=3)
public void EditPic() throws InterruptedException
{
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@id='personal_details']//i[@class='icon-pr-edit']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//i[@class='icon-camera']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("custom-input")).click();
}

}
