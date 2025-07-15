package Bai17_PageObjectModel.pages;

import com.junvu.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By totalInvoicesAwaitingPayment = By.xpath("(//span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");
    private By totalConvertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");
    private By totalProjectsInProgress = By.xpath("(//span[normalize-space()='Projects In Progresss']/parent::div)/following-sibling::span");
    private By totalTasksNotFinished = By.xpath("(//span[normalize-space()='Tasks Not Finished']/parent::div)/following-sibling::span");


    public void verifyInvoicesAwaitingPaymentTotal(String total) {
        Assert.assertTrue(driver.findElement(totalInvoicesAwaitingPayment).isDisplayed(), "The Invoices Awaiting Payment total label not display.");
        Assert.assertEquals(WebUI.getTextElement(totalInvoicesAwaitingPayment), total, "The Invoices Awaiting Payment total not match.");
    }

    public void verifyConvertedLeadsTotal(String total) {
        Assert.assertTrue(driver.findElement(totalConvertedLeads).isDisplayed(), "The Converted Leads total label not display.");
        Assert.assertEquals(WebUI.getTextElement(totalConvertedLeads), total, "The Converted Leads total not match.");
    }

    public void verifyProjectsInProgressTotal(String total) {
        Assert.assertTrue(driver.findElement(totalProjectsInProgress).isDisplayed(), "The Projects In Progresss total label not display.");
        Assert.assertEquals(WebUI.getTextElement(totalProjectsInProgress), total, "The Projects In Progresss total not match.");
    }

    public void verifyTasksNotFinishedTotal(String total) {
        Assert.assertTrue(driver.findElement(totalTasksNotFinished).isDisplayed(),"The Tasks Not Finished total label not display.");
        Assert.assertEquals(WebUI.getTextElement(totalTasksNotFinished), total, "The Tasks Not Finished total not match.");
    }
}
