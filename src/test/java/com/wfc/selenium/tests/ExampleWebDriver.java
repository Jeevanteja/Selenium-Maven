package com.wfc.selenium.tests;

import java.util.List;

import com.wfc.selenium.DriverFactory;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleWebDriver extends DriverFactory {

    @Test
    public void exampleCode() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();

        // And now use this to visit Amazon Page
       driver.navigate().to("http://www.amazon.com");
     Assert.assertEquals("Welcome",driver.findElement(By.cssSelector("h2")).getText());
       System.out.println(" We are on Amazon Home Page");
      
        driver.findElement(By.name("field-keywords")).clear();
        driver.findElement(By.name("field-keywords")).sendKeys("Men Shoes");
        driver.findElement(By.cssSelector("#nav-search > form > div.nav-right > div > input")).click();
        System.out.println("Searching for Men Shoes");
        Assert.assertEquals("MEN'S SHOES",driver.findElement(By.cssSelector("h1")).getText());
        System.out.println("Showing the list of Men Shoes");
        
        WebElement elment=driver.findElement(By.xpath("//*[@id='sort']"));
              
      selectDropdown(elment,"Price: High to Low");
  
      System.out.println("back here");
        driver.findElement(By.cssSelector("#sort")).click();
        
    }		
	public void selectDropdown(WebElement slocator, String value){
		List<WebElement> getDropDownValues=slocator.findElements(By.tagName("option"));
		boolean match = false;
		System.out.println("Total no. of dropdown values:"+ getDropDownValues.size());
		for(int i = 0; i< getDropDownValues.size();i++){
			System.out.println(getDropDownValues.get(i).getText());
			 if (getDropDownValues.get(i).getText().equalsIgnoreCase(value)){
				 getDropDownValues.get(i).click();
				 match = true;
				 break;}

		}
		if(!match){
			System.out.println("No Selection Found");
			Assert.fail(value + "Not found in the dropdown " + slocator);
			 
		}
	  }
}
