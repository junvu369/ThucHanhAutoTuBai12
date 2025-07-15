package com.junvu.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebUI {

    private static WebDriver driver;

    public WebUI(WebDriver driver) {
        this.driver = driver;
    }

    //Hàm chung mở website
    public static void openWebsite(String url) {
        System.out.println("Open website: " + url);
        driver.get(url);
    }

    //Hàm chung cho click: wait trước khi click
    public static void clickElement(By by) {
        System.out.println("Click on element "+ by); //Ghi log bằng lệnh in
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(by));
//        waitForElementToBeClickabe(by);
        driver.findElement(by).click();
    }

    //Hàm chung cho sendKeys: wait trước khi sendKeys
    public static void setText(By by, String text) {
        System.out.println("Set text " + text + " on element "+ by);//Ghi log bằng lệnh in
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(text);
    }

    //Hàm chung cho clearText: wait trước khi clear
    public static void clearText(By by) {
        System.out.println("Clear text in element "+ by);//Ghi log bằng lệnh in
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).clear();
    }

    //Hàm chung cho getText: wait trước khi getText
    public static String getTextElement(By by) {
        System.out.println("Get text of element "+ by);//Ghi log bằng lệnh in
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//        waitForElementVisible(by);
        String text = driver.findElement(by).getText();
        System.out.println("==> Text: "+ text);//Ghi log bằng lệnh in
        return driver.findElement(by).getText();
    }
    //Kiểm tra xem element có hiển thị trên giao diện hay không
    public static void waitForElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementVisible(By by, int second) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementToBeClickabe(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
