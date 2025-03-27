package Bai16_ThuchanhWaits;

import com.junvu.keywords.WebUI;
import common.BaseTest;
import common.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ThuchanhWaits_02 extends BaseTest {

    @Test
    public void testCustomerCRM() throws InterruptedException {
        new WebUI(driver);  //Khởi tạo class WebUI để truyền driver từ BaseTest vào

        driver.get("https://crm.anhtester.com/admin/authentication");

        WebUI.clearText(By.xpath(LocatorsCRM.inputEmail));
        WebUI.clearText(By.xpath(LocatorsCRM.inputPassword));
//        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
//        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();

        WebUI.setText(By.xpath(LocatorsCRM.inputEmail),"admin@example.com");
        WebUI.setText(By.xpath(LocatorsCRM.buttonLogin),"123456");

//        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
//        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");

        WebUI.clickElement(By.xpath(LocatorsCRM.buttonLogin));
//        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        WebUI.clickElement(By.xpath(LocatorsCRM.menuCustomers));
//        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();

        System.out.println(WebUI.getTextElement(By.xpath(LocatorsCRM.headerCustomerPage)));
//        System.out.println(driver.findElement(By.xpath(LocatorsCRM.headerCustomerPage)).getText());

        WebUI.clickElement(By.xpath(LocatorsCRM.buttonAddNewCustomer));
//        driver.findElement(By.xpath(LocatorsCRM.buttonAddNewCustomer)).click();
//        Thread.sleep(2000);

        WebUI.setText(By.xpath(LocatorsCRM.inputCompany),"Viettel VTCC01");
//        driver.findElement(By.xpath(LocatorsCRM.inputCompany)).sendKeys("Viettel VTCC01");

        WebUI.setText(By.xpath(LocatorsCRM.inputVat),"10");
//        driver.findElement(By.xpath(LocatorsCRM.inputVat)).sendKeys("10");

        WebUI.setText(By.xpath(LocatorsCRM.inputPhoneNumber),"0123456789");
//        driver.findElement(By.xpath(LocatorsCRM.inputPhoneNumber)).sendKeys("0123456789");

        WebUI.setText(By.xpath(LocatorsCRM.inputWebsite),"https://viettel.com.vn/");
//        driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).sendKeys("https://viettel.com.vn/");

        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownGroup));
//        driver.findElement(By.xpath(LocatorsCRM.dropdownGroup)).click();
//        Thread.sleep(1000);

        WebUI.setText(By.xpath(LocatorsCRM.inputSearchGroup),"VIP");
//        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroup)).sendKeys("VIP"); //Chỗ này search giá trị nên có thể ko cần wait
//        Thread.sleep(1000);

        WebUI.clickElement(By.xpath(LocatorsCRM.itemVIP));
//        driver.findElement(By.xpath(LocatorsCRM.itemVIP)).click();

        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownGroup));
//        driver.findElement(By.xpath(LocatorsCRM.dropdownGroup)).click();
//        Thread.sleep(1000);

        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownLanguage));
//        driver.findElement(By.xpath(LocatorsCRM.dropdownLanguage)).click();
//        Thread.sleep(1000);

        WebUI.clickElement(By.xpath(LocatorsCRM.itemVietnamese));
//        driver.findElement(By.xpath(LocatorsCRM.itemVietnamese)).click();

        WebUI.setText(By.xpath(LocatorsCRM.inputAddress),"Ha Noi");
//        driver.findElement(By.xpath(LocatorsCRM.inputAddress)).sendKeys("Ha Noi");

        WebUI.setText(By.xpath(LocatorsCRM.inputCity),"Ha Noi");
//        driver.findElement(By.xpath(LocatorsCRM.inputCity)).sendKeys("Ha Noi");

        WebUI.setText(By.xpath(LocatorsCRM.inputState),"Hoan Kiem");
//        driver.findElement(By.xpath(LocatorsCRM.inputState)).sendKeys("Hoan Kiem");

        WebUI.setText(By.xpath(LocatorsCRM.inputZipCode),"123456");
//        driver.findElement(By.xpath(LocatorsCRM.inputZipCode)).sendKeys("123456");
//        Thread.sleep(1000);

        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownCountry));
//        driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click();
//        Thread.sleep(1000);

        WebUI.setText(By.xpath(LocatorsCRM.inputSearchCountry),"Vietnam");
//        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys("Vietnam");
//        Thread.sleep(1000);

        WebUI.clickElement(By.xpath(LocatorsCRM.itemVietnamCountry));
//        driver.findElement(By.xpath(LocatorsCRM.itemVietnamCountry)).click();
//        Thread.sleep(1000);

        WebUI.clickElement(By.xpath(LocatorsCRM.buttonSave));
//        driver.findElement(By.xpath(LocatorsCRM.buttonSave)).click();


        //Check alert message nếu có
        //Tiếp theo check item customer hiển thị tại trang Cutsomer list
        Thread.sleep(1000);

        WebUI.clickElement(By.xpath(LocatorsCRM.menuCustomers));
//        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();

        WebUI.setText(By.xpath(LocatorsCRM.inputSearchCustomer),"Viettel VTCC01");
//        driver.findElement(By.xpath(LocatorsCRM.inputSearchCustomer)).sendKeys("Viettel VTCC01");
//        Thread.sleep(2000);
        
        //ĐANG Ở ĐÂY

        System.out.println(driver.findElement(By.xpath(LocatorsCRM.itemCustomerFirst)).isDisplayed());
        System.out.println("Customer in List: " + driver.findElement(By.xpath(LocatorsCRM.itemCustomerFirst)).getText());
        //Tiếp theo check Customer đúng hết data sau khi add
        driver.findElement(By.xpath(LocatorsCRM.itemCustomerFirst)).click();
        Thread.sleep(2000);
        System.out.println("Company Detail: " + driver.findElement(By.xpath(LocatorsCRM.inputCompany)).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath(LocatorsCRM.inputVat)).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath(LocatorsCRM.inputPhoneNumber)).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath(LocatorsCRM.dropdownGroup)).getAttribute("title"));
        System.out.println(driver.findElement(By.xpath(LocatorsCRM.dropdownLanguage)).getAttribute("title"));

        //Cuối cùng phải check dạng Integration (liên kết với module khác)
        //Ví dụ customer sẽ được hiển thị bên trang project (nằm trong dropdown)
        Thread.sleep(2000);

    }
}

