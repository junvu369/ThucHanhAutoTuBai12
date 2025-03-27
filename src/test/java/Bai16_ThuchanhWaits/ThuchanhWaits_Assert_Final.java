package Bai16_ThuchanhWaits;

import com.junvu.keywords.WebUI;
import common.BaseTest;
import common.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThuchanhWaits_Assert_Final extends BaseTest {

    @Test
    public void testCustomerCRM() throws InterruptedException {
        String CUSTOMER_NAME = "Viettel VTCC10";

        new WebUI(driver);  //Khởi tạo class WebUI để truyền driver từ BaseTest vào

        driver.get("https://crm.anhtester.com/admin/authentication");
        System.out.println("Open website: https://crm.anhtester.com/admin/authentication"); //Lệnh in ghi log

        WebUI.clearText(By.xpath(LocatorsCRM.inputEmail));
        WebUI.clearText(By.xpath(LocatorsCRM.inputPassword));

        WebUI.setText(By.xpath(LocatorsCRM.inputEmail), "admin@example.com");
        WebUI.setText(By.xpath(LocatorsCRM.inputPassword), "123456");

        WebUI.clickElement(By.xpath(LocatorsCRM.buttonLogin));

        WebUI.clickElement(By.xpath(LocatorsCRM.menuCustomers));

        System.out.println(WebUI.getTextElement(By.xpath(LocatorsCRM.headerCustomerPage)));

        WebUI.clickElement(By.xpath(LocatorsCRM.buttonAddNewCustomer));

        WebUI.setText(By.xpath(LocatorsCRM.inputCompany), CUSTOMER_NAME);

        WebUI.setText(By.xpath(LocatorsCRM.inputVat), "10");

        WebUI.setText(By.xpath(LocatorsCRM.inputPhoneNumber), "0123456789");

        WebUI.setText(By.xpath(LocatorsCRM.inputWebsite), "https://viettel.com.vn/");

        //Scroll down đến label Group
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement groupLabel = driver.findElement(By.xpath("//label[normalize-space()='Groups']"));
        js.executeScript("arguments[0].scrollIntoView(true);", groupLabel);

        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownGroup));
        Thread.sleep(1000); //Giữ nguyên Thread.sleep để chờ droplist xổ ra

        WebUI.setText(By.xpath(LocatorsCRM.inputSearchGroup), "VIP");
        Thread.sleep(1000);//Giữ nguyên Thread.sleep để chờ item VIP hiển thị

        WebUI.clickElement(By.xpath(LocatorsCRM.itemVIP));

        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownGroup));

        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownLanguage));

        WebUI.clickElement(By.xpath(LocatorsCRM.itemVietnamese));

        WebUI.setText(By.xpath(LocatorsCRM.inputAddress), "Ha Noi");

        WebUI.setText(By.xpath(LocatorsCRM.inputCity), "Ha Noi");

        WebUI.setText(By.xpath(LocatorsCRM.inputState), "Hoan Kiem");

        WebUI.setText(By.xpath(LocatorsCRM.inputZipCode), "123456");

        WebUI.clickElement(By.xpath(LocatorsCRM.dropdownCountry));

        WebUI.setText(By.xpath(LocatorsCRM.inputSearchCountry), "Vietnam");

        WebUI.clickElement(By.xpath(LocatorsCRM.itemVietnamCountry));

        WebUI.clickElement(By.xpath(LocatorsCRM.buttonSave));

        //Check alert message nếu có
        //Tiếp theo check item customer hiển thị tại trang Customer list

        WebUI.clickElement(By.xpath(LocatorsCRM.menuCustomers));

        WebUI.setText(By.xpath(LocatorsCRM.inputSearchCustomer), CUSTOMER_NAME);
        Thread.sleep(2000); //Giữ lại Thread.sleep để chờ kết quả search được load thành công

        WebUI.waitForElementVisible(By.xpath(LocatorsCRM.itemCustomerFirst));
        Assert.assertEquals(WebUI.getTextElement(By.xpath(LocatorsCRM.itemCustomerFirst)), CUSTOMER_NAME, "Tên khách hàng được lưu chưa đúng");

        //Tiếp theo check Customer đúng hết data sau khi add
        WebUI.clickElement(By.xpath(LocatorsCRM.itemCustomerFirst));

        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.inputCompany)).getAttribute("value"), CUSTOMER_NAME, "The company name is not matched. ");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.inputVat)).getAttribute("value"), "10", "The VAT value is not matched. ");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.inputPhoneNumber)).getAttribute("value"), "0123456789", "The Phone Number is not matched. ");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).getAttribute("value"), "https://viettel.com.vn/", "The Website is not matched. ");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.dropdownGroup)).getAttribute("title"), "VIP", "The chosen group is not matched. ");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.dropdownLanguage)).getAttribute("title"), "Vietnamese", "The language is not matched. ");

        //Cuối cùng phải check dạng Integration (liên kết với module khác)
        //Ví dụ customer sẽ được hiển thị bên trang project (nằm trong dropdown)
    }
}

