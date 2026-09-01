package Bai20_21_Practise_CRM_POM.pages;

import com.junvu.keywords.WebUI;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

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
    private By checkBoxCalculateProgressThroughTasks = By.xpath("//label[@for='progress_from_tasks']");
    private By sliderProgress = By.xpath("//input[@id='progress_from_tasks']");
    private By dropdownlistBillingType = By.xpath("//button[@title='Fixed Rate']");
    private By selectBillingType = By.xpath("//a[@id='bs-select-1-2']");
    private By dropdownListStatus = By.xpath("//button[@title='In Progress']");
    private By selectStatus = By.xpath("//a[@id='bs-select-2-2']");
    private By inputRatePerHour = By.xpath("//input[@id='project_rate_per_hour']");
    private By inputTotalRate = By.xpath("//input[@id='project_cost']");
    private By inputeEstimatedHours = By.xpath("//input[@id='estimated_hours']");
    private By labelMembers = By.xpath("//label[normalize-space()='Members']");
    private By dropdownlistMembers = By.xpath("//button[@title='Admin Example']");
    private By deselectAllListMembers = By.xpath("//div[@class='dropdown bootstrap-select show-tick bs3 open']//button[@type='button'][normalize-space()='Deselect All']");
    private By selectMembers = By.xpath("//a[@id='bs-select-3-1']");
    private By datePickerStartDate = By.xpath("//input[@id='start_date']");
    private By datePickerDeadline = By.xpath("//input[@id='deadline']");
    private By labelTags = By.xpath("//label[normalize-space()='Tags']");
    private By dropdownListTags = By.xpath("//input[@placeholder='Tag']");
    private By selectTags = By.xpath("//div[@class='ui-menu-item-wrapper']");
    private By labelDescription = By.xpath("//p[normalize-space()='Description']");
    private By iframeDescription = By.xpath("//iframe[@id='description_ifr']");
    private By textareaDescription = By.xpath("//body[@id='tinymce']");
    private By labelcheckboxSendProjectCreatedEmail = By.xpath("//label[normalize-space()='Send project created email']");
    private By buttonSave = By.xpath("//button[normalize-space()='Save']");
    private By headerProjectDetailPage = By.xpath("//button[@data-id='project_top']");
    private By customerValueInProjectDetail = By.xpath("//dt[normalize-space()='Customer']/following-sibling::dd");
    private By billingTypeValueInProjectDetail = By.xpath("//dt[normalize-space()='Billing Type']/following-sibling::dd[1]");
    private By totalRateValueInProjectDetail = By.xpath("//dt[normalize-space()='Total Rate']/following-sibling::dd[1]");
    private By ratePerHourValueInProjectDetail = By.xpath("//dt[normalize-space()='Rate Per Hour']/following-sibling::dd[1]");
    private By statusValueInProjectDetail = By.xpath("//dt[normalize-space()='Status']/following-sibling::dd[1]");
    private By startDateValueInProjectDetail = By.xpath("//dt[normalize-space()='Start Date']/following-sibling::dd[1]");
    private By deadlineValueInProjectDetail = By.xpath("//dt[normalize-space()='Deadline']/following-sibling::dd[1]");
    private By estimatedHoursValueInProjectDetail = By.xpath("//dt[normalize-space()='Estimated Hours']/following-sibling::dd[1]");
    private By tagValueInProjectDetail = By.xpath("//span[@class='tagit-label']");
    private By descriptionContentInProjectDetail = By.xpath("//dt[normalize-space()='Description']/following-sibling::dd[1]");
    private By firstCustomerWhenSearching = By.xpath("//span[@class='text']");
    private By allCustomerWhenSearching = By.xpath("//ul[@role='presentation']/li");

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

        WebUI.sleep(1);
        WebUI.setText(inputRatePerHour, "20");

        WebUI.setText(inputeEstimatedHours, "100");

        WebUI.clickElement(dropdownlistMembers);
        WebUI.clickElement(deselectAllListMembers);
        WebUI.clickElement(selectMembers);
        WebUI.sleep(1);
        WebUI.clickElement(labelMembers);

        WebUI.clickElement(datePickerStartDate);
        WebUI.clearText(datePickerStartDate);
        WebUI.setText(datePickerStartDate, "02-09-2026");
        WebUI.clickElement(datePickerStartDate);

        WebUI.clearText(datePickerDeadline);
        WebUI.setText(datePickerDeadline, "10-09-2026");
        WebUI.clickElement(datePickerDeadline);

        WebUI.clickElement(dropdownListTags);
        WebUI.sleep(1);
        WebUI.clickElement(selectTags);
        WebUI.clickElement(labelTags);

        // Scroll đến Description
        WebElement iframe = driver.findElement(labelDescription);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                iframe
        );
        //Chuyển hướng đến Frame thông qua chính element thẻ iFrame
        driver.switchTo().frame(driver.findElement(iframeDescription));
        WebUI.clickElement(textareaDescription);
        WebUI.setText(textareaDescription, "This is a test project");
        driver.switchTo().parentFrame();

        WebUI.clickElement(labelcheckboxSendProjectCreatedEmail);

        WebUI.clickElement(buttonSave);
    }

    //Verify navigate to Project Detail screen
    public void verifyNavigateToProjectDetailPage(String projectName) {
        Assert.assertTrue(checkElementExist(headerProjectDetailPage), "The project detail header does not display.");
        Assert.assertEquals(WebUI.getWebElement(headerProjectDetailPage).getText(), "New Project 3008 - Test Company 01", "The project detail header is not matched.");
    }

    //Verify Project Detail data
    public void verifyAddNewProjectSuccess(String projectName) {
        Assert.assertEquals(WebUI.getWebElement(headerProjectDetailPage).getText(), "New Project 3008 - Test Company 01", "The project detail header is not matched.");
        Assert.assertEquals(driver.findElement(customerValueInProjectDetail).getText(), "Test Company 01", "Customer Value is not matched.");
        Assert.assertEquals(driver.findElement(billingTypeValueInProjectDetail).getText(), "Project Hours", "Billing Type Value is not matched.");
        Assert.assertEquals(driver.findElement(ratePerHourValueInProjectDetail).getText(), "$20.00", "Rate Per Hour Value is not matched");
        Assert.assertEquals(driver.findElement(statusValueInProjectDetail).getText(), "On Hold", "Status Value is not matched.");
        Assert.assertEquals(driver.findElement(startDateValueInProjectDetail).getText(), "02-09-2026", "Start Date Value is not matched.");
        Assert.assertEquals(driver.findElement(deadlineValueInProjectDetail).getText(), "10-09-2026", "Deadline Value is not matched.");
        Assert.assertEquals(driver.findElement(estimatedHoursValueInProjectDetail).getText(), "100:00", "Estimated Hours Value is not matched.");
        Assert.assertEquals(driver.findElement(tagValueInProjectDetail).getText(), "auto", "Tags Value is not matched.");
        Assert.assertEquals(driver.findElement(descriptionContentInProjectDetail).getText(), "This is a test project", "Description Content is not matched.");
    }

    //Search tìm tên customer tuyệt đối
    public void checkCustomerNameInProjectDetail() {
        WebUI.clickElement(dropdownListCustomer);
        WebUI.setText(inputSearchCustomer, "Anh Tester 0109");
        Assert.assertEquals(driver.findElement(firstCustomerWhenSearching).getText(), "Anh Tester 0109", "The new customer name does not exist in Project Detail screen.");
    }

    //Search tìm tên customer tương đối
    public void searchCustomer(String searchKeyword) {
        WebUI.clickElement(dropdownListCustomer);
        WebUI.setText(inputSearchCustomer, searchKeyword);
    }

    //Verify
    public boolean isCustomerDisplayed(String customerName) {
        List<WebElement> customers = driver.findElements(allCustomerWhenSearching);

        for (WebElement customer : customers) {
            String actualCustomerName = customer.getText();
            System.out.println("Customer found: " + actualCustomerName);

            if (actualCustomerName.equals(customerName)) {
                return true;
            }
        }
        return false;
    }
}
