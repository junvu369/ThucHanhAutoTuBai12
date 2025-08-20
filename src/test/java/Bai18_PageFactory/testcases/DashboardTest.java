package Bai18_PageFactory.testcases;

import Bai18_PageFactory.pages.DashboardPage;
import Bai18_PageFactory.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void checkDashboardTotal() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM(); //Chỉ login

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyInvoicesAwaitingPaymentTotal("1 / 3");
        dashboardPage.verifyConvertedLeadsTotal("1 / 1");
        dashboardPage.verifyProjectsInProgressTotal("62 / 80");
        dashboardPage.verifyTasksNotFinishedTotal("91 / 91");
    }

}
