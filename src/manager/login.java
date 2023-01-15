package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class login extends Parameters {

	@Test(priority = 1)
	public void LoginAsManager() throws InterruptedException {

		driver.get(HomePage);
		driver.manage().window().maximize();
		WebElement ManagerLoginButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button"));
		ManagerLoginButton.click();
		
		WebElement AddCustomer =  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]"));
		AddCustomer.click();
		
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")).sendKeys(FirstName);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input")).sendKeys(LastName);
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input")).sendKeys(PostalCodeString);
		WebElement AddCustomerButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button"));
		AddCustomerButton.click();
		Thread.sleep(1000);
		String Msg = driver.switchTo().alert().getText();
		myAssertion.assertEquals(Msg.contains("successfully"), true);
		myAssertion.assertAll();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

}
	@Test(priority = 2)
	public void OpenAccount() throws InterruptedException {
		
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]")).click();
		
		WebElement sel = driver.findElement(By.xpath("//*[@id=\"userSelect\"]"));
		Select customerSelect = new Select(sel);
		customerSelect.selectByVisibleText(CustomerName);
		
		WebElement sel2 = driver.findElement(By.xpath("//*[@id=\"currency\"]"));
		Select  CurrencySelect = new Select(sel2);
		CurrencySelect.selectByVisibleText(Currency);
		Thread.sleep(1000);
		WebElement Process = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button"));
		Process.click();
		
		String Msg = driver.switchTo().alert().getText();
		myAssertion.assertEquals(Msg.contains("successfully"), true);
		myAssertion.assertAll();
		driver.switchTo().alert().accept();
	
	}
	
	@Test(priority = 3)
	public void FindCustomers() {
		
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]")).click();
		WebElement Search = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input"));
		Search.sendKeys(FirstName);

		myAssertion.assertEquals(CustomerName,FirstName+LastName);
		myAssertion.assertAll();
	
	}
}
