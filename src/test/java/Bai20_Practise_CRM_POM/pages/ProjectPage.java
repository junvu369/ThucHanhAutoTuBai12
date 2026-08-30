package Bai20_Practise_CRM_POM.pages;

import com.junvu.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

// Kế thừa BasePage
public class ProjectPage extends BasePage {
    private WebDriver driver;

    //Khai báo Webdriver và constructor
    public ProjectPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    //Khai báo Locators
    private By headerProjectPage = By.xpath("//span[normalize-space()='Projects Summary']");
    private By buttonNewProject = By.xpath("//a[normalize-space()='New Project']");
    private By inputProjectName = By.xpath("//input[@id='name']");
    private By dropdownListCustomer = By.xpath("//button[@data-id='clientid']");
    private By inputSearchCustomer = By.xpath("//div[@class='dropdown bootstrap-select ajax-search bs3 open']//input[@placeholder='Type to search...']");
    private By selectCustomer = By.xpath("//a[@id='bs-select-6-0']");
    private By checkBoxCalculateProgressThroughTasks = By.xpath("//input[@id='progress_from_tasks']");
    private By sliderProgress = By.xpath("//input[@id='progress_from_tasks']");
    private By dropdownlistBillingType = By.xpath("//button[@title='Fixed Rate']");
    private By selectBillingType = By.xpath("//a[@id='bs-select-1-2']");
    private By dropdownListStatus = By.xpath("//button[@title='In Progress']");
    private By selectStatus = By.xpath("//a[@id='bs-select-2-2']");
    private By inputRatePerHour = By.xpath("//input[@id='project_rate_per_hour']");
    private By inputTotalRate = By.xpath("//input[@id='project_cost']");
    private By inputeEstimatedHours = By.xpath("//input[@id='estimated_hours']");
    private By dropdownlistMembers = By.xpath("//button[@title='Admin Example']");
    private By selectMembers = By.xpath("//a[@id='bs-select-3-1']");
    private By datePickerStartDate = By.xpath("//input[@id='start_date']");
    private By datePickerDeadline = By.xpath("//input[@id='deadline']");
    private By dropdownListTags = By.xpath("//input[@placeholder='Tag']");
    private By selectTags = By.xpath("//div[@id='ui-id-1097']");
    private By textareaDescription = By.xpath("//iframe[@id='description_ifr']");
    private By checkboxSendProjectCreatedEmail = By.xpath("//input[@id='send_created_email']");
    private By buttonSave = By.xpath("//button[normalize-space()='Save']");
    private By headerProjectDetailPage = By.xpath("//button[@data-id='project_top']");
    private By customerValueInProjectDetail = By.xpath("//a[contains(@href, 'https://crm.anhtester.com/admin/clients/client/')]]");
    private By billingTypeValueInProjectDetail = By.xpath("//dt[normalize-space()='Billing Type']/following-sibling::dd[1]");
    private By totalRateValueInProjectDetail = By.xpath("//dt[normalize-space()='Total Rate']/following-sibling::dd[1]");
    private By statusValueInProjectDetail = By.xpath("//dt[normalize-space()='Status']/following-sibling::dd[1]");
    private By startDateValueInProjectDetail = By.xpath("//dt[normalize-space()='Start Date']/following-sibling::dd[1]");
    private By deadlineValueInProjectDetail = By.xpath("//dt[normalize-space()='Deadline']/following-sibling::dd[1]");
    private By estimatedHoursValueInProjectDetail = By.xpath("//dt[normalize-space()='Estimated Hours']/following-sibling::dd[1]");
    private By tagValueInProjectDetail = By.xpath("//input[@id='tags']");
    private By descriptionContentInProjectDetail = By.xpath("//dt[normalize-space()='Description']/following-sibling::dd[1]");

    //Action thao tác với page và Verification (nếu có)
    private boolean checkElementExist(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            return true;
        } catch (NoSuchElementException e) {
            return false;//Đừng bắn lỗi từ hệ thống Selenium ra đây
        }
    }

    public void verifyNavigateToProjectPage() {
        Assert.assertTrue(checkElementExist(headerProjectPage), "The Project header page does not display.");
        Assert.assertEquals(WebUI.getTextElement(headerProjectPage), "Projects Summary", "The Project header page is not matched.");
    }

    public void clickButtonAddNewProject() {
        WebUI.clickElement(buttonNewProject);
    }

    public void submitDataForNewProject(String projectName) {
        WebUI.setText(inputProjectName, projectName);

        WebUI.clickElement(dropdownListCustomer);
        WebUI.sleep(1);
        WebUI.setText(inputSearchCustomer, "Test Company 01");
        WebUI.clickElement(selectCustomer);

        WebUI.sleep(1);
        WebUI.clickElement(checkBoxCalculateProgressThroughTasks);

        WebUI.clickElement(dropdownlistBillingType);
        WebUI.sleep(1);
        WebUI.clickElement(selectBillingType);

        WebUI.clickElement(dropdownListStatus);
        WebUI.sleep(1);
        WebUI.clickElement(selectStatus);

        WebUI.setText(inputTotalRate, "100");

        WebUI.setText(inputeEstimatedHours, "10");

        WebUI.clickElement(dropdownlistMembers);
        WebUI.sleep(1);
        WebUI.clickElement(selectMembers);
        WebUI.clickElement(dropdownlistMembers);

        WebUI.clickElement(datePickerStartDate);
        WebUI.clearText(datePickerStartDate);
        WebUI.setText(datePickerStartDate, "02-09-2026");
        WebUI.clickElement(datePickerStartDate);

        WebUI.clearText(datePickerDeadline);
        WebUI.setText(datePickerDeadline, "10-09-2026");
        WebUI.clearText(datePickerDeadline);

        WebUI.clickElement(dropdownListTags);
        WebUI.sleep(1);
        WebUI.clickElement(selectTags);
        WebUI.clickElement(dropdownListTags);

        //Chuyển hướng đến Frame thông qua chính element thẻ iFrame
        driver.switchTo().frame(driver.findElement(textareaDescription));
        WebUI.setText(textareaDescription, "This is a test project");
        driver.switchTo().parentFrame();

        WebUI.clickElement(checkboxSendProjectCreatedEmail);

        WebUI.clickElement(buttonSave);
    }

    //Verify navigate to Project Detail screen
    public void verifyNavigateToProjectDetailPage(String projectName) {
        Assert.assertTrue(checkElementExist(headerProjectDetailPage), "The project detail header does not display.");
        Assert.assertEquals(WebUI.getWebElement(headerProjectDetailPage),projectName, "The project detail header is not matched.");
    }

    //Verify Project Detail data
    public void verifyAddNewProjectSuccess(String projectName) {
        Assert.assertEquals(WebUI.getWebElement(headerProjectDetailPage),projectName, "The project detail header is not matched.");
        Assert.assertEquals(driver.findElement(customerValueInProjectDetail),"Test Company 01","Customer Value is not matched.");
        Assert.assertEquals(driver.findElement(billingTypeValueInProjectDetail),WebUI.getTextElement(selectBillingType),"Billing Type Value is not matched.");
        Assert.assertEquals(driver.findElement(totalRateValueInProjectDetail),"100","Total Rate Value is not matched");
        Assert.assertEquals(driver.findElement(statusValueInProjectDetail), WebUI.getTextElement(selectStatus),"Status Value is not matched.");
        Assert.assertEquals(driver.findElement(startDateValueInProjectDetail),"02-09-2026","Start Date Value is not matched.");
        Assert.assertEquals(driver.findElement(deadlineValueInProjectDetail),"10-09-2026","Deadline Value is not matched.");
        Assert.assertEquals(driver.findElement(estimatedHoursValueInProjectDetail),"10:00","Estimated Hours Value is not matched.");
        Assert.assertEquals(driver.findElement(tagValueInProjectDetail),"fast","Tags Value is not matched.");
        Assert.assertEquals(driver.findElement(descriptionContentInProjectDetail),"This is a test project","Description Content is not matched.");
    }

}
