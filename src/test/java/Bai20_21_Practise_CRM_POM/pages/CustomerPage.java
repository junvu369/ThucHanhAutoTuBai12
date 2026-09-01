package Bai20_21_Practise_CRM_POM.pages;

import com.junvu.keywords.WebUI;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CustomerPage extends BasePage {
    private WebDriver driver;

    public CustomerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    private By headerCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By buttonAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomers = By.xpath("//a[normalize-space()='Import Customers']");
    private By inputSearchCustomer = By.xpath("//div[@id='clients_filter']//input[@type='search']");
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVat = By.xpath("//input[@id='vat']");
    private By inputPhoneNumber = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By dropdownGroup = By.xpath("//button[@data-id='groups_in[]']");
    private By inputSearchGroup = By.xpath("//button[@data-id='groups_in[]']/following-sibling::div//input");
    private By itemVIP = By.xpath("//a[@id='bs-select-1-301']");
    private By dropdownLanguage = By.xpath("//button[@data-id='default_language']");
    private By itemVietnamese = By.xpath("//span[normalize-space()='Vietnamese']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By dropdownCountry = By.xpath("//button[@data-id='country']");
    private By inputSearchCountry = By.xpath("//button[@data-id='country']/following-sibling::div//input");
    private By itemVietnamCountry = By.xpath("//button[@data-id='country']/following-sibling::div//span[normalize-space()='Vietnam']");
    private By buttonSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");
    private By itemCustomerFirst = By.xpath("//table[@id='clients']/tbody/tr[1]/td[3]/a");
    private By contactCustomer = By.xpath("//a[normalize-space()='Contacts']");
    private By addContactButton = By.xpath("//a[normalize-space()='New Contact']");
    private By firstNameInContact = By.xpath("//input[@id='firstname']");
    private By lastNameInContact = By.xpath("//input[@id='lastname']");
    private By emailInContact = By.xpath("//input[@id='email']");
    private By passwordInContact = By.xpath("//input[@name='password']");
    private By saveButtonInContact = By.xpath("//button[normalize-space()='Save']");
    private By searchContact = By.xpath("//input[@class='form-control input-sm']");
    private By fullNameFirstContact = By.xpath("//table[@id='DataTables_Table_0']//tbody//tr[1]//td[1]/a[1]");
    private By emailFirstContact = By.xpath("//table[@id='DataTables_Table_0']//tbody//tr[1]//td[2]//a");

    //4 total in customer list
    private By totalCustomers = By.xpath("//span[normalize-space()='Total Customers']/preceding-sibling::span");
    private By headerCustomerDetailPage = By.xpath("//h4[normalize-space()='Profile']");


    private boolean checkElementExist(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
//            driver.findElement(by).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;//Đừng bắn lỗi từ hệ thống Selenium ra đây
        }
    }

    public void verifyNavigateToCustomerPage() {
        Assert.assertTrue(checkElementExist(headerCustomerPage), "The customer header page is not displayed");
        Assert.assertEquals(WebUI.getTextElement(headerCustomerPage), "Customers Summary", "The customer header is not matched.");
    }

    public void clickButtonAddNewCustomer() {
        WebUI.clickElement(buttonAddNewCustomer);
    }

    public void submitDataForNewCustomer(String customerName) {
        WebUI.setText(inputCompany, customerName);
        WebUI.setText(inputVat, "10");
        WebUI.setText(inputPhoneNumber, "0123456789");
        WebUI.setText(inputWebsite, "www.viettel.com.vn");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement groupLabel = driver.findElement(By.xpath("//label[normalize-space()='Groups']"));
        js.executeScript("arguments[0].scrollIntoView(true);", groupLabel);

        WebUI.clickElement(dropdownGroup);
        WebUI.sleep(1);
        WebUI.setText(inputSearchGroup, "VIP");

        WebUI.sleep(1);
        WebUI.clickElement(itemVIP);
        WebUI.clickElement(dropdownGroup);
        WebUI.clickElement(dropdownLanguage);
        WebUI.clickElement(itemVietnamese);
        WebUI.setText(inputAddress, "234 Pham Van Dong");
        WebUI.setText(inputCity, "Ha Noi");
        WebUI.setText(inputState, "Bac Tu Liem");
        WebUI.setText(inputZipCode, "123456");
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, "Vietnam");
        WebUI.clickElement(itemVietnamCountry);

        WebUI.clickElement(buttonSave);
    }

    //Verify navigate to Customer Detail page
    public void verifyNavigateToCustomerDetailPage() {
        Assert.assertTrue(checkElementExist(headerCustomerDetailPage), "The customer detail header page is not displayed");
        Assert.assertEquals(WebUI.getTextElement(headerCustomerDetailPage), "Profile", "The customer detail header is not matched.");
    }

    public void verifyAddNewCustomerSuccess(String customerName) {
        //Verify alert message

        //Verify customer data in detail
        Assert.assertEquals(driver.findElement(inputCompany).getAttribute("value"), customerName, "The company name does not match");
        Assert.assertEquals(driver.findElement(inputVat).getAttribute("value"), "10", "The VAT value does not match");
        Assert.assertEquals(driver.findElement(inputPhoneNumber).getAttribute("value"), "0123456789", "The phone value does not match");
        Assert.assertEquals(driver.findElement(inputWebsite).getAttribute("value"), "www.viettel.com.vn", "The website does not exist");
        Assert.assertEquals(driver.findElement(dropdownGroup).getAttribute("title"), "VIP", "The group does not match");
        Assert.assertEquals(driver.findElement(dropdownLanguage).getAttribute("title"), "Vietnamese", "The language does not match");
    }

    public void searchAndCheckCustomerInTable(String customerName) {

        WebUI.clickElement(menuCustomers);
        WebUI.setText(inputSearchCustomer, customerName);
        WebUI.sleep(2);
        String customerNameInTable = WebUI.getElementText(itemCustomerFirst);
        System.out.println(customerNameInTable);
        Assert.assertEquals(customerNameInTable, customerName, "The customer name in table does not match.");

    }

    public void clickFirstCustomer() {
        WebUI.clickElement(itemCustomerFirst);
    }

    public int getTotalCustomers() {
        String totalString = driver.findElement(totalCustomers).getText();
        System.out.println("getCustomerTotal: " + totalString);
        return Integer.parseInt(totalString); //Hàm chuyển về kiểu Int
    }

    public void addnewContactsuccessfully(String contactEmail, String contactPassword) {
        WebUI.setText(inputSearchCustomer, "Anh Tester 0109");
        WebUI.sleep(1);
        clickFirstCustomer();
        WebUI.sleep(1);
        WebUI.clickElement(contactCustomer);
        WebUI.clickElement(addContactButton);
        WebUI.sleep(1);
        WebUI.setText(firstNameInContact, "Anh");
        WebUI.setText(lastNameInContact, "Tester");

        WebUI.setText(emailInContact, contactEmail);
        WebUI.setText(passwordInContact, contactPassword);

        WebElement element = driver.findElement(saveButtonInContact);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                element
        );

        WebUI.clickElement(saveButtonInContact);
        WebUI.sleep(2);
        driver.navigate().refresh();

        WebUI.setText(searchContact, "Anh");
        Assert.assertEquals(driver.findElement(fullNameFirstContact).getText(), "Anh Tester", "The full name of new contact displays correctly.");
        Assert.assertEquals(driver.findElement(emailFirstContact).getText(), contactEmail, "The email of new contact displays correctly.");
    }
}
