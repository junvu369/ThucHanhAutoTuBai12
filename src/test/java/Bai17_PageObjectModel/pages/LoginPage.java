package Bai17_PageObjectModel.pages;

import com.junvu.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {

    //Khai báo driver cục bộ
    private WebDriver driver;

    //Khai báo hàm xây dựng, để truyền driver từ bên ngoài vào chính class này sử dụng
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver); //Khởi tạo giá trị driver cho class WebUI

    }

    //Khai báo các element dạng đối tượng By (phương thức tìm kiếm)

    private By headerLogin = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[contains(@class,'alert-danger')]");
    private By errorMessage1 = By.xpath("(//div[contains(@class,'alert-danger')])[1]");
    private By errorMessage2 = By.xpath("(//div[contains(@class,'alert-danger')])[2]");
    private By remmemberMeCheckbox = By.xpath("//input[@id='remember']");
    private By forgotPasswordTextlink = By.xpath("//div/a[@href='https://crm.anhtester.com/admin/authentication/forgot_password']");
    private By headerForgotPassword = By.xpath("//h1[normalize-space()='Forgot Password']");
    private By inputemailAddress = By.xpath("//input[@id='email']");
    private By buttonComfirm = By.xpath("//button[normalize-space()='Confirm']");

    //Khai báo sẵn các hàm nội bộ trang Login

    public void setEmail(String email) {
//        driver.findElement(inputEmail).sendKeys(email);
        WebUI.setText(inputEmail, email);
    }

    public void setPassword(String password) {
//        driver.findElement(inputPassword).sendKeys(password);
        WebUI.setText(inputPassword, password);
    }

    public void clickLoginButton() {
//        driver.findElement(buttonLogin).click();
        WebUI.clickElement(buttonLogin);
    }

    public void tickOnRememberMe() {
        WebUI.clickElement(remmemberMeCheckbox);
    }

    public void clickOnForgotPassword() {
        WebUI.clickElement(forgotPasswordTextlink);
    }

    public void clickOnConfirmButton() {
        WebUI.clickElement(buttonComfirm);
    }

    public void verifyLoginSuccess() {
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail() {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Errror message does not display");
        Assert.assertEquals(driver.findElement(errorMessage).getText(), "Invalid email or password", "Content of error massage does not match");
    }

    // Hàm chung cho các error message
    public void verifyLoginFail(String message) {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Errror message does not display");
        Assert.assertEquals(driver.findElement(errorMessage).getText(), message, "Content of error massage does not match");
    }

    public void verifyLoginFailWithNullFields() {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(driver.findElement(errorMessage1).isDisplayed(), "Errror message 1 does not display");
        Assert.assertTrue(driver.findElement(errorMessage2).isDisplayed(), "Errror message 2 does not display");

        Assert.assertEquals(WebUI.getTextElement(errorMessage1), "The Password field is required.", "Content of error massage 1 does not match");
        Assert.assertEquals(WebUI.getTextElement(errorMessage2), "The Email Address field is required.", "Content of error massage 2 does not match");

    }

    public void verifyForgotPasswordSuccessfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("forgot_password"), "Chưa đến trang Forgot Password");
        Assert.assertTrue(driver.findElement(headerForgotPassword).isDisplayed(), "Header Forgot Password is not display");


        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message does not display");
        Assert.assertEquals(WebUI.getTextElement(errorMessage), "Error setting new password", "Content of error massage does not match");
    }


//Thầy viết - Nâng cao với ArrrayList và vòng lặp For (áp dụng cho 1 màn có quá nhiều error message và tối đa hóa code, không bị trùng lặp)
//
//    public void verifyLoginFailWithNullFields_ArrayList(int totalNullFields) {
//        // Kiểm tra vẫn đang ở trang Login
//        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
//
//        // Danh sách các thông báo lỗi mong đợi
//        List<String> messageString = new ArrayList<>();
//        messageString.add("The Password field is required.");
//        messageString.add("The Email Address field is required.");
//
//        boolean check = false;
//        int index = 0;
//        // Duyệt qua từng lỗi hiển thị
//        for ( int i = 1; i<= totalNullFields; i++){
//            Assert.assertTrue(driver.findElement(By.xpath("(//div[contains(@class,'alert-danger')])["+ i +"]")).isDisplayed(), "Errror message "+ i +" does not display");
//
//            for (int j = 0; j < messageString.size(); j++){
//                if (WebUI.getTextElement(By.xpath("(//div[contains(@class,'alert-danger')])["+ i +"]")).equals(messageString.get(j))){
//                    check = true;
//                    break;
//                }
//            }
//
//            Assert.assertTrue(check, "The content of error message "+ i +" not match");
//        }
//    }
//    Check code thầy
//    Vì bạn đang so sánh từng thông báo thực tế với từng phần tử trong danh sách mong đợi, nên mỗi thông báo lỗi có thể bị đọc lại nhiều lần, nếu nó không khớp ngay từ lần đầu.

//    Ở i = 2, phần tử thứ 2 được gọi 2 lần:
//
//    Lần 1: để so sánh với dòng "The Password field is required." → ❌ không match
//
//    Lần 2: để so sánh với dòng "The Email Address field is required." → ✅ match
//
// -> Vì không có Assert trong vòng j, chương trình không fail ngay ở lần không match. Nó chỉ kiểm tra check sau vòng j.

    public void verifyLoginFailWithNullFields_ArrayListOptimized(int totalNullFields) {
        // Kiểm tra vẫn ở trang login
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");

        // Danh sách thông báo lỗi mong đợi
        List<String> expectedMessages = new ArrayList<>();
        expectedMessages.add("The Password field is required.");
        expectedMessages.add("The Email Address field is required.");
        // Có thể thêm các dòng lỗi khác nếu cần

        for (int i = 1; i <= totalNullFields; i++) {
            By locator = By.xpath("(//div[contains(@class,'alert-danger')])[" + i + "]");

            // Kiểm tra hiển thị
            Assert.assertTrue(driver.findElement(locator).isDisplayed(), "❌ Error message " + i + " is not displayed.");

            // ✅ GỌI getTextElement 1 lần duy nhất
            String actualMessage = WebUI.getTextElement(locator);
            System.out.println("🔍 Message " + i + ": " + actualMessage);

            // ✅ So sánh với tất cả expected messages
            boolean matchFound = false;
            for (String expected : expectedMessages) {
                if (actualMessage.equals(expected)) {
                    matchFound = true;
                    System.out.println("✅ Matched with expected: " + expected);
                    break;
                }
            }

            // ❌ Nếu không khớp dòng nào → Fail
            Assert.assertTrue(matchFound, "❌ Message " + i + " content does not match any expected message.");
        }
    }

    //Các hàm xử lý cho chính trang này
    public void loginCRM(String email, String password) { //Truyền tham số ở đây để tùy ý điều chỉnh email và pasword
//        driver.get("https://crm.anhtester.com/admin/authentication");
        //Cách 1: Dùng hàm chung (có thể ghi log, dùng thread sleep)
//        setEmail(email);
//        setPassword(password);
//        clickLoginButton();

        //Cách 2: Dùng driver.findElement
//        driver.findElement(inputEmail).sendKeys(email);
//        driver.findElement(inputPassword).sendKeys(password);
//        driver.findElement(buttonLogin).click();


        //Cách 3: Gọi hàm chung từ WebUI vào, không cần dùng cách 1 và 2 và không dùng 3 hàm private trung gian phía trên nữa
        WebUI.openWebsite("https://crm.anhtester.com/admin/authentication");
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogin);
    }

    //Hàm Log in mới này sẽ dùng cho các Page khác
    public void loginCRM() {

        WebUI.openWebsite("https://crm.anhtester.com/admin/authentication");
        WebUI.setText(inputEmail, "admin@example.com");
        WebUI.setText(inputPassword, "123456");
        WebUI.clickElement(buttonLogin);
        verifyLoginSuccess();
    }

    public void forgotPassword(String email) {
        clickOnForgotPassword();
        setEmail(email);
        clickOnConfirmButton();
    }

}