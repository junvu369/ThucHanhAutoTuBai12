package Bai20_21_Practise_CRM_POM.pages;

import com.junvu.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Common Page dùng để thiết lập các element chung không thuộc về trang nào cụ thể, cùng với đó là các hàm xử lý chung được dùng ở nhiều Page
public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //Menu chung
    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By menuTasks = By.xpath("//span[normalize-space()='Tasks']");
    public By menuContracts = By.xpath("//span[normalize-space()='Contracts']");
    public By menuSales = By.xpath("//li[@class='menu-item-sales']");
    public By menuSubscriptions = By.xpath("//span[normalize-space()='Subscriptions']");
    public By menuExpenses = By.xpath("//li[@class='menu-item-expenses']");
    public By menuSupport = By.xpath("//span[normalize-space()='Support']");
    public By menuLeads = By.xpath("//li[@class='menu-item-leads']");
    public By menuEstimateRequest = By.xpath("//span[normalize-space()='Estimate Request']");
    public By menuKnowledgeBase = By.xpath("//span[normalize-space()='Knowledge Base']");
    public By menuUtilities = By.xpath("//span[normalize-space()='Utilities']");
    public By menuReports = By.xpath("//span[normalize-space()='Reports']");
    public By seachBoxOnTop = By.xpath("//input[@id='search_input']");
    public By quickCreateButton = By.xpath("//li[normalize-space()='Quick Create']");
    public By quickCreateInvoice = By.xpath("//a[@href='https://crm.anhtester.com/admin/invoices/invoice']");
    public By quickCreateEstimate = By.xpath("//a[@href='https://crm.anhtester.com/admin/estimates/estimate']");
    public By quickCreateProposal = By.xpath("//a[@href='https://crm.anhtester.com/admin/proposals/proposal']");
    public By quickCreateCreditNote = By.xpath("//a[@href='https://crm.anhtester.com/admin/credit_notes/credit_note']");
    public By quickCreateCustomer = By.xpath("//li[normalize-space()='Quick Create']/following-sibling::li/a[@href='https://crm.anhtester.com/admin/clients/client']");
    public By quickCreateSubcription = By.xpath("//a[@href='https://crm.anhtester.com/admin/subscriptions/create']");
    public By quickCreateProject = By.xpath("//a[@href='https://crm.anhtester.com/admin/projects/project']");

    public CustomerPage clickMenuCustomer() {
        WebUI.waitForElementVisible(menuCustomers);
        WebUI.clickElement(menuCustomers);

        return new CustomerPage(driver);
    }

    public ProjectPage clickMenuProject() {
        WebUI.waitForElementVisible(menuProjects);
        WebUI.clickElement(menuProjects);

        return new ProjectPage(driver);
    }
}
