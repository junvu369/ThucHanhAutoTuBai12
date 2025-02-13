package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void createDriver() {
        //Chạy chế độ ẩn danh
        // Cấu hình ChromeOptions
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");  // Mở trình duyệt ở chế độ ẩn danh

        // Khởi tạo WebDriver
//        driver = new ChromeDriver(options);

        driver = new ChromeDriver();
//        driver = new EdgeDriver();
        driver.manage().window().maximize();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
