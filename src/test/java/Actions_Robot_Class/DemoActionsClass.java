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
    public void testSendKeys() throws InterruptedException {

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
    public void testPressEnterKey() throws InterruptedException {

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
    public void testClick() throws InterruptedException {
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
        softAssert.assertEquals(elementCategoryHeader.getText(), "All categories", "CategoryHeader is not matched");
        Thread.sleep(2000);

        softAssert.assertAll();
    }

    @Test
    public void doubleClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-6 col-md-6']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

        Actions action = new Actions(driver);

        action.doubleClick(element).perform();
        Thread.sleep(2000);
    }

    //Test click bằng chuột phải
    @Test
    public void contextClick() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-6 col-md-6']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

        Actions action = new Actions(driver);

        action.contextClick(element).perform();
        Thread.sleep(2000);
    }

    @Test
    public void moveToElement() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));

        Actions action = new Actions(driver);

        //Move to element (di chuyển tới title Kiến thức Automation Testing)
        action.moveToElement(element).perform();

        Thread.sleep(2000);
    }

    @Test
    public void demoDragAndDropWithActionClass() throws InterruptedException {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        Thread.sleep(2000);

        // Bắt element cần kéo
        WebElement From1 = driver.findElement(By.xpath("//div[@id='box1']"));
        WebElement From2 = driver.findElement(By.xpath("//div[@id='box2']"));
        WebElement From3 = driver.findElement(By.xpath("//div[@id='box3']"));
        WebElement From4 = driver.findElement(By.xpath("//div[@id='box4']"));
        WebElement From5 = driver.findElement(By.xpath("//div[@id='box5']"));
        WebElement From6 = driver.findElement(By.xpath("//div[@id='box6']"));
        WebElement From7 = driver.findElement(By.xpath("//div[@id='box7']"));

        // Bắt element cần thả đến
        WebElement To1 = driver.findElement(By.xpath("//div[@id='countries']//div[@id='box101']"));
        WebElement To2 = driver.findElement(By.xpath("//div[@id='countries']//div[@id='box102']"));
        WebElement To3 = driver.findElement(By.xpath("//div[@id='countries']//div[@id='box103']"));
        WebElement To4 = driver.findElement(By.xpath("//div[@id='countries']//div[@id='box104']"));
        WebElement To5 = driver.findElement(By.xpath("//div[@id='countries']//div[@id='box105']"));
        WebElement To6 = driver.findElement(By.xpath("//div[@id='countries']//div[@id='box106']"));
        WebElement To7 = driver.findElement(By.xpath("//div[@id='countries']//div[@id='box107']"));


        Thread.sleep(2000);
        Actions action = new Actions(driver);
        // Kéo và thả các elements
        action.dragAndDrop(From1, To1).perform();
        Thread.sleep(2000);
        action.dragAndDrop(From2, To2).perform();
        Thread.sleep(2000);
        action.dragAndDrop(From3, To3).perform();
        Thread.sleep(2000);
        action.dragAndDrop(From4, To4).perform();
        Thread.sleep(2000);
        action.dragAndDrop(From5, To5).perform();
        Thread.sleep(2000);
        action.dragAndDrop(From6, To6).perform();
        Thread.sleep(2000);
        action.dragAndDrop(From7, To7).perform();
        Thread.sleep(2000);
    }

    @Test
    public void dragAndDropWithCRM() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");

        //Log in
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

        //Click vào Tasks từ SubMenu (ĐANG LỖI Ở ĐÂY)
        WebElement elementTasks = driver.findElement(By.xpath("//a[@href='https://crm.anhtester.com/admin/tasks']"));
        action.click(elementTasks).perform();
        Thread.sleep(2000);

        //Switch to Kanban
        WebElement elementSwitchToKanban = driver.findElement(By.xpath("//a[@href='https://crm.anhtester.com/admin/tasks/switch_kanban/']"));
        action.click(elementSwitchToKanban).perform();
        Thread.sleep(2000);

        // Bắt element cần kéo
        WebElement elementTaskFrom1 = driver.findElement(By.xpath("//li[@data-task-id='1']"));

        // Bắt element cần thả
        WebElement elementTaskTo1 = driver.findElement(By.xpath("//div[@class='kan-ban-content']/ul[@data-task-status-id='3']"));

        //Kéo và thả các elements
        action.dragAndDrop(elementTaskFrom1, elementTaskTo1).perform();
        Thread.sleep(2000);

    }

    //Test KeyDown và KeyUp (đè phím và nhấc phím)
    //Chuyển văn bản sang chữ in hoa
    @Test
    public void inputTextUppercase() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//input[@id='email']"));

        Actions action = new Actions(driver);

        // Đè giữ phím SHIFT và nhập text -> Chữ in hoa
        action.keyDown(element, Keys.SHIFT).sendKeys("admin@example.com").keyUp(Keys.SHIFT).build().perform();
        action.sendKeys("acb1234").perform();
        Thread.sleep(2000);
    }

    //Cuộn lên và xuống trang
    @Test
    public void scrollPageDownAndUp1() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Scroll down
        action.keyDown(Keys.END).perform();
        action.keyUp(Keys.END).perform();
        Thread.sleep(2000);
        // Scroll up
        action.keyDown(Keys.HOME).perform();
        action.keyUp(Keys.HOME).perform();
        Thread.sleep(2000);
    }

    @Test
    public void scrollPageDownAndUp2() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Actions action = new Actions(driver);

        Thread.sleep(1000);
        //Scroll down
        action.keyDown(Keys.CONTROL).keyDown(Keys.END).perform();
        action.keyUp(Keys.END).perform();
        Thread.sleep(2000);

        // Scroll up
        action.keyDown(Keys.HOME).perform();
        action.keyUp(Keys.HOME).keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
    }

    //Test copy and paste
    @Test
    public void copyAndPaste() throws InterruptedException {
        driver.get("https://anhtester.com/blogs");
        Thread.sleep(2000);

        WebElement inputCourseElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm khóa học')]"));
        WebElement inputBlogElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm bài viết')]"));

        Actions action = new Actions(driver);

        Thread.sleep(1000);
        // Nhập text vào ô search course
        inputCourseElement.sendKeys("Selenium");
        Thread.sleep(1000);
        //Ctrl + a để bôi đen
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        //Ctrl + c để copy
        action.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        //click vào ô Blog search
        inputBlogElement.click();
        Thread.sleep(1000);
        //Ctrl + v để dán
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

        Thread.sleep(2000);

        //Làm mới trang
        action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
        Thread.sleep(4000);

    }


}