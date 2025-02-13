package Actions_Robot_Class;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DemoActionsClass extends BaseTest {
    @Test
    public void TestSendKeys() throws InterruptedException {

        //driver kế thừa từ class SetupBrowser
        driver.get("https://cms.anhtester.com/login");

        // Khai báo Elements
        WebElement elementEmail = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement elementPassword = driver.findElement(By.xpath("//input[@id='password']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(elementEmail, "admin@example.com").perform();
        action.sendKeys(elementPassword, "123456").perform();
        Thread.sleep(2000);
    }

    @Test
    public void TestPressEnterKey() throws InterruptedException {

        //driver kế thừa từ class SetupBrowser
        driver.get("https://cms.anhtester.com/login");

        // Khai báo Elements
        WebElement elementEmail = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement elementPassword = driver.findElement(By.xpath("//input[@id='password']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(elementEmail, "admin@example.com").perform();
        action.sendKeys(elementPassword, "123456").perform();
        Thread.sleep(2000);

        //Ấn phím ENTER bằng action class
        action.sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);
    }

    @Test
    public void TestClick() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        //driver kế thừa từ class SetupBrowser
        driver.get("https://cms.anhtester.com/login");

        // Khai báo Elements
        WebElement elementEmail = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement elementPassword = driver.findElement(By.xpath("//input[@id='password']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(elementEmail, "admin@example.com").perform();
        action.sendKeys(elementPassword, "123456").perform();
        Thread.sleep(2000);

        //Ấn phím ENTER bằng action class
        action.sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);

        // Get element bất kỳ để thực hiện thao tác click
        WebElement elementProductMenu = driver.findElement(By.xpath("//span[normalize-space()='Products']"));
        softAssert.assertEquals(elementProductMenu.getText(), "Products", "ProductMenu name is not matched.");

        // Gọi hàm click để click element Products
        action.click(elementProductMenu).perform();
        Thread.sleep(3000);
        //Kiểm tra tên Submenu đã chọn đúng chưa
        WebElement elementCategoryMenu = driver.findElement(By.xpath("(//ul[@id='main-menu']/descendant::ul[@class='aiz-side-nav-list level-2 mm-collapse mm-show']/li)[8]"));
        softAssert.assertEquals(elementCategoryMenu.getText(), "Category", "CategoryMenu name is not matched.");

        // Gọi hàm click để click element Category
        action.click(elementCategoryMenu).perform();
        Thread.sleep(1000);
        //Kiểm tra header trang Category
        WebElement elementCategoryHeader = driver.findElement(By.xpath("//h1[normalize-space()='All categories']"));
        softAssert.assertEquals(elementCategoryHeader.getText(),"All categories","CategoryHeader is not matched");
        Thread.sleep(2000);

        softAssert.assertAll();
    }

    
}