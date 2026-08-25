package Bai20_Practise_CRM_POM.testcases;

import Bai20_Practise_CRM_POM.pages.DashboardPage;
import Bai20_Practise_CRM_POM.pages.LoginPage;
import Bai20_Practise_CRM_POM.pages.CustomerPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testAddNewCustomer() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        customerPage = dashboardPage.clickMenuCustomer();

        String customerName = "Anh Tester 2811";

        customerPage.verifyNavigateToCustomerPage();
        customerPage.clickButtonAddNewCustomer();
        customerPage.submitDataForNewCustomer(customerName);
        customerPage.verifyNavigateToCustomerDetailPage();
        customerPage.verifyAddNewCustomerSuccess(customerName);

    }


    //  Liệt kê ra những hàm trong Automation
//  clickAddNew customer
//  searchData
//  checkData1stRow
//  checkTotalCustomerNumber


}
