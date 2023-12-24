package yopmail;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TestYopmail {
    public static void main(String[] args) {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://yopmail.com/en/");

        driver.findElement(By.cssSelector("#login")).sendKeys("automationtest");

        driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();

        WebElement iframe = driver.findElement(By.cssSelector("#ifinbox"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//button[@class='lm'])[1]"));
        driver.switchTo().defaultContent();

        WebElement iframe2 = driver.findElement(By.cssSelector("#ifmail"));
        driver.switchTo().frame(iframe2);

        String txtActualHeader =  driver.findElement(By.xpath("(//div[@class='ellipsis nw b f18'])[1]")).getText();
        String txtExpectedHeader = "Welcome to Brick&Bolt! (Service Request ID:CRN299116 )";
        Assert.assertEquals(txtActualHeader,txtExpectedHeader);

        // Close WebDriver
        driver.quit();
    }
}
