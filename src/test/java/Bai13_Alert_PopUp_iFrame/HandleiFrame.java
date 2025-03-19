package Bai13_Alert_PopUp_iFrame;

import common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleiFrame extends BaseTest {
    @Test
    public void demoHandleiFrame1() throws InterruptedException {
        driver.get("https://demoqa.com/frames");
        Thread.sleep(2000);

        //Chuyển hướng dến iframe thông qua chính element thẻ iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));
        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
        //Chuyển hướng về nội dung chính không thuộc thẻ iframe nào
        driver.switchTo().parentFrame();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Frames']")).getText());
        Thread.sleep(1000);
    }
}
