package Bai20_Practise_CRM_POM.testcases;

import Bai19_PageNavigation.pages.DashboardPage;
import Bai19_PageNavigation.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

    public class DashboardTest extends BaseTest {

        LoginPage loginPage;
        DashboardPage dashboardPage;

        @Test(priority = 1)
        public void testCheckDashboardTotal(){
            loginPage = new LoginPage(driver);

            //loginPage.loginCRM();

            //dashboardPage = new DashboardPage(driver);

            dashboardPage = loginPage.loginCRM();
            dashboardPage.verifyInvoicesAwaitingPaymentTotal("0 / 2");
        }

    }
