package Bai20_21_Practise_CRM_POM.testcases;

import Bai20_21_Practise_CRM_POM.pages.DashboardPage;
import Bai20_21_Practise_CRM_POM.pages.LoginPage;
import Bai20_21_Practise_CRM_POM.pages.CustomerPage;
import Bai20_21_Practise_CRM_POM.pages.ProjectPage;
import com.junvu.keywords.WebUI;
import common.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(CustomerTest.class);
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    ProjectPage projectPage;

    @Test
    public void testAddNewCustomer() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        customerPage = dashboardPage.clickMenuCustomer();

        String customerName = "Anh Tester 0109";

        customerPage.verifyNavigateToCustomerPage();
        int beforeTotal = customerPage.getTotalCustomers();
        customerPage.clickButtonAddNewCustomer();
        customerPage.submitDataForNewCustomer(customerName);
        customerPage.verifyNavigateToCustomerDetailPage();
        customerPage.verifyAddNewCustomerSuccess(customerName);

        customerPage.clickMenuCustomer();
        int afterTotal = customerPage.getTotalCustomers();
        Assert.assertEquals(afterTotal, beforeTotal + 1, " The total customer before and after add new are not matched.");
    }


    @Test
    public void testAddNewCustomer2() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        customerPage = dashboardPage.clickMenuCustomer();

        String customerName = "Anh Tester 0109";

        customerPage.verifyNavigateToCustomerPage();
        int beforeTotal = customerPage.getTotalCustomers();
        customerPage.clickButtonAddNewCustomer();
        customerPage.submitDataForNewCustomer(customerName);

        //Search and check customer name in table
        customerPage.searchAndCheckCustomerInTable(customerName);

        //Verify data of new customer in profile page
        customerPage.clickFirstCustomer();
        customerPage.verifyNavigateToCustomerDetailPage();
        customerPage.verifyAddNewCustomerSuccess(customerName);

        //Compare the total customer before and after adding new customer
        customerPage.clickMenuCustomer();
        int afterTotal = customerPage.getTotalCustomers();
        Assert.assertEquals(afterTotal, beforeTotal + 1, " The total customer before and after add new are not matched.");

    }

    @Test
    public void checkCustomerNameinProjectDetail() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        projectPage = dashboardPage.clickMenuProject();

        projectPage.clickButtonAddNewProject();
        projectPage.checkCustomerNameInProjectDetail();
    }

    @Test
    public void checkCustomerNameinProjectDetail2() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        projectPage = dashboardPage.clickMenuProject();

        projectPage.clickButtonAddNewProject();
        projectPage.searchCustomer("Anh Tester");

        Assert.assertTrue(projectPage.isCustomerDisplayed("Anh Tester"),"The new customer is not found.");
    }

    @Test
    public void addContactForNewCustomerSuccesfully(){

        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        customerPage = dashboardPage.clickMenuCustomer();
        customerPage.addnewContactsuccessfully("anhtester@yopmail.com","123456");
    }

    @Test
    public void addContactAndLoginSuccessfully(){
        //Add contact successfully
        String contactEmail = "ahntester@yopmail.com";
        String contactPassword = "123456";

        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        customerPage = dashboardPage.clickMenuCustomer();
        customerPage.addnewContactsuccessfully(contactEmail, contactPassword);

        //Log out
        loginPage.logoutsuccessfully();
        driver.navigate().refresh();

        //Log in với contact vừa tạo
        loginPage.loginCRM(contactEmail,contactPassword);

        //Verify Log in thành công > Hiện đang bị block do hệ thống không cho log in luôn sau khi add contact
        loginPage.verifyLoginSuccess();
    }
}
