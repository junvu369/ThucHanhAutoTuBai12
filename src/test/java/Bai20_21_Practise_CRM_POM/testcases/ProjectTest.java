package Bai20_21_Practise_CRM_POM.testcases;

import Bai20_21_Practise_CRM_POM.pages.DashboardPage;
import Bai20_21_Practise_CRM_POM.pages.LoginPage;
import Bai20_21_Practise_CRM_POM.pages.ProjectPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProjectPage projectPage;

    @Test
    public void addNewProject (){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        projectPage = dashboardPage.clickMenuProject();

        String projectName = "New Project 3008";

        projectPage.verifyNavigateToProjectPage();
        projectPage.clickButtonAddNewProject();
        projectPage.submitDataForNewProject(projectName);
        projectPage.verifyNavigateToProjectDetailPage(projectName);
        projectPage.verifyAddNewProjectSuccess(projectName);
    }
}
