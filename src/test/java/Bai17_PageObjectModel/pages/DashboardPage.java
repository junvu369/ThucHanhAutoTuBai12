package Bai17_PageObjectModel.pages;

import com.beust.ah.A;
import com.junvu.keywords.WebUI;
import net.bytebuddy.implementation.auxiliary.MethodCallProxy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {

    //Khai báo driver
    private WebDriver driver;

    //Dùng hàm xây dựng để truyền driver từ bên ngoài vào
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    //Danh sách Elements
    private By dashboardMenu = By.xpath("(//ul[@id='side-menu']/child::li)[2]");

    private By buttonDashboardOptions = By.xpath("//div[@class='screen-options-btn']");
    private By labelDashboardOptions = By.xpath("//div[@id='dashboard-options']//a[@href='https://crm.anhtester.com/admin/staff/reset_dashboard']/preceding-sibling::h4");
    private By textlinkResetDashboard = By.xpath("//div[@id='dashboard-options']//a[@href='https://crm.anhtester.com/admin/staff/reset_dashboard']");
    private By textlinkViewOrHideWidgetableArea = By.xpath("//div[@id='dashboard-options']//a[@id='viewWidgetableArea']");
    private By checkboxQuickStatistics = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox'])[1]");
    private By labelQuickStatistics = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox']/label)[1]");
    private By checkboxFinanceOverview = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox'])[2]");
    private By labelFinanceOverview = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox']/label)[2]");
    private By checkboxUserWidget = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox'])[3]");
    private By labelUserWidget = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox']/label)[3]");
    private By checkboxCalendar = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox'])[4]");
    private By labelCalendar = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox']/label)[4]");
    private By checkboxPaymentRecords = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox'])[5]");
    private By labelPaymentRecords = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox']/label)[5]");
    private By checkboxContractsExpiringSoon = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox'])[6]");
    private By labelContractsExpiringSoon = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox']/label)[6]");
    private By checkboxMyToDoItems = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox'])[7]");
    private By labelMyToDoItemsInDashboardOptions = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox']/label)[7]");
    private By checkboxLeadsChart = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox'])[8]");
    private By labelLeadschart = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox']/label)[8]");
    private By checkboxProjectsChart = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox'])[9]");
    private By labelProjectsChart = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox']/label)[9]");
    private By checkboxLatestProjectActivity = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox'])[10]");
    private By labelLatestProjectActivity = By.xpath("(//div[@id='dashboard-options']/div[@class='checkbox']/label)[10]");


    private By labelInvoicesAwaitingPayment = By.xpath("//span[normalize-space()='Invoices Awaiting Payment']");
    private By totalInvoicesAwaitingPayment = By.xpath("(//span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");

    private By labelConvertedLeads = By.xpath("//span[normalize-space()='Converted Leads']");
    private By totalConvertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");

    private By labelProjectsInProgress = By.xpath("//span[normalize-space()='Projects In Progress']");
    private By totalProjectsInProgress = By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span");

    private By labelTasksNotFinished = By.xpath("//span[normalize-space()='Tasks Not Finished']");
    private By totalTasksNotFinished = By.xpath("(//span[normalize-space()='Tasks Not Finished']/parent::div)/following-sibling::span");


    private By labelMyToDoItems = By.xpath("//span[normalize-space()='My To Do Items']");

    private By textlinkViewAll = By.xpath("//div/a[@href='https://crm.anhtester.com/admin/todo']");
    private By buttonNewToDo = By.xpath("//a[@href='#__todo']");

    private By textlinkNewToDo = By.xpath("//div/a[@href='#__todo']");
    private By textboxDescriptionNewToDo = By.xpath("//textarea[@id='description']");
    private By buttonSaveNewToDo = By.xpath("//button[@type='submit']");
    private By buttonCloseNewToDo = By.xpath("//button[@type='button' and normalize-space()='Close']");

    private By labelLatestToDo = By.xpath("//h4[normalize-space()='Latest to do's']");
    private By checkboxLatestToDo = By.xpath("(//input[@name='todo_id'])[1]");
    private By iconEditLatestToDo = By.xpath("(//i[@class='fa fa-pencil'])[1]");
    private By iconDeleteLatestToDo = By.xpath("(//i[@class='fa fa-remove fa-lg'])[1]");

    private By labelLatestFinishedToDo = By.xpath("//h4[normalize-space()='Latest finished to do's']");
    private By checkboxLatestFinishedToDo = By.xpath("(//input[@name='todo_id'])[5]");
    private By iconEditLatestFinishedToDo = By.xpath("(//i[@class='fa fa-pencil'])[5]");
    private By iconDeleteLatestFinishedToDo = By.xpath("(//i[@class='fa fa-remove fa-lg'])[5]");

    private By labelInvoiceOverview = By.xpath("//span[normalize-space()='Invoice overview']");
    private By textlinkInvoiceDraft = By.xpath("//a[@href='https://crm.anhtester.com/admin/invoices/list_invoices?status=6']");
    private By textlinkInvoiceNotSent = By.xpath("//a[@href='https://crm.anhtester.com/admin/invoices/list_invoices?filter=not_sent']");
    private By textlinkInvoiceUnpaid = By.xpath("//a[@href='https://crm.anhtester.com/admin/invoices/list_invoices?status=1']");
    private By textlinkInvoicePartiallyPaid = By.xpath("//a[@href='https://crm.anhtester.com/admin/invoices/list_invoices?status=3']");
    private By textlinkInvoiceOverDue = By.xpath("//a[@href='https://crm.anhtester.com/admin/invoices/list_invoices?status=4']");
    private By textlinkInvoicePaid = By.xpath("//a[@href='https://crm.anhtester.com/admin/invoices/list_invoices?status=2']");

    private By labelEstimateOverview = By.xpath("//span[normalize-space()='Estimate overview']");
    private By textlinkEstimateDraft = By.xpath("//a[@href='https://crm.anhtester.com/admin/estimates/list_estimates?status=1']");
    private By textlinkEstimateNotSent = By.xpath("//a[@href='https://crm.anhtester.com/admin/estimates/list_estimates?not_sent=1']");
    private By textlinkEstimateSent = By.xpath("//a[@href='https://crm.anhtester.com/admin/estimates/list_estimates?status=2']");
    private By textlinkEstimateExpired = By.xpath("//a[@href='https://crm.anhtester.com/admin/estimates/list_estimates?status=5']");
    private By textlinkEstimateDeclined = By.xpath("//a[@href='https://crm.anhtester.com/admin/estimates/list_estimates?status=3']");
    private By textlinkEstimateAccepted = By.xpath("//a[@href='https://crm.anhtester.com/admin/estimates/list_estimates?status=4']");

    private By labelProposalOverview = By.xpath("//span[normalize-space()='Proposal overview']");
    private By textlinkProposalDraft = By.xpath("//a[@href='https://crm.anhtester.com/admin/proposals/list_proposals?status=6']");
    private By textlinkProposalSent = By.xpath("//a[@href='https://crm.anhtester.com/admin/proposals/list_proposals?status=4']");
    private By textlinkProposalOpen = By.xpath("//a[@href='https://crm.anhtester.com/admin/proposals/list_proposals?status=1']");
    private By textlinkProposalRevised = By.xpath("//a[@href='https://crm.anhtester.com/admin/proposals/list_proposals?status=5']");
    private By textlinkProposalDeclined = By.xpath("//a[@href='https://crm.anhtester.com/admin/proposals/list_proposals?status=2']");
    private By textlinkProposalAccepted = By.xpath("//a[@href='https://crm.anhtester.com/admin/proposals/list_proposals?status=3']");

    private By dropdownlistInvoiceYear = By.xpath("//div[@id='invoices_total']//div[@class='filter-option-inner-inner']");
    private By invoiceYear2025 = By.xpath("//span[normalize-space()='2025']");
    private By invoiceYear2024 = By.xpath("//span[normalize-space()='2024']");
    private By labelOutstandingInvoices = By.xpath("//div/dt[normalize-space()='Outstanding Invoices']");
    private By dataOutstandingInvoices = By.xpath("(//div[@id='invoices_total']/dl//dd)[1]");
    private By labelPastDueInvoices = By.xpath("//div/dt[normalize-space()='Past Due Invoices']");
    private By dataPastDueInvoices = By.xpath("(//div[@id='invoices_total']/dl//dd)[2]");
    private By labelPaidInvoices = By.xpath("//div/dt[normalize-space()='Paid Invoices']");
    private By dataPaidInvoices = By.xpath("(//div[@id='invoices_total']/dl//dd)[3]");

    private By tabMyTasks = By.xpath("//a[@href='#home_tab_tasks']");
    private By tabMyProjects = By.xpath("//a[@href='#home_my_projects']");
    private By tabMyReminders = By.xpath("//a[@href='#home_my_reminders']");
    private By tabTickets = By.xpath("//a[@href = '#home_tab_tickets']");
    private By tabAnnouncements = By.xpath("//a[@href='#home_announcements']");

    //Khai báo các hàm xử lý

    //1. Dashboard Options

    public void clickDashboardsettingsbutton() {
        Assert.assertTrue(driver.findElement(buttonDashboardOptions).isDisplayed(), "Button Dashboard Options is not displayed.");
        WebUI.clickElement(buttonDashboardOptions);
    }

    public void verifyDisplayOfDashboardsettings() {
        Assert.assertTrue(driver.findElement(labelDashboardOptions).isDisplayed(), "The Dashboard Options title is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelDashboardOptions), "Widgets", "The Dashboard Options label is not matched.");
    }

    public void clickOnResetDashboardTextLink() {
        WebUI.clickElement(textlinkResetDashboard);
    }

    public void clickOnViewOrHideWidgetableArea() {
        WebUI.clickElement(textlinkViewOrHideWidgetableArea);
    }

    public void verifyQuickStatisticCheckbox(String label) {
        Assert.assertTrue(driver.findElement(labelQuickStatistics).isDisplayed(), "The label Quick Statistics is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelQuickStatistics), label, "The content of label Quick Statistics is not matched.");
        Assert.assertTrue(driver.findElement(checkboxQuickStatistics).isDisplayed(), "The checkbox Quick Statistics is not displayed.");
    }

    public void clickOnQuickStatisticCheckbox() {
        WebUI.clickElement(checkboxQuickStatistics);
    }

    public void verifyFinanceOverviewCheckbox(String label) {
        Assert.assertTrue(driver.findElement(labelFinanceOverview).isDisplayed(), "The label Finance Overview is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelFinanceOverview), label, "The content of label Finance Overview is not matched.");
        Assert.assertTrue(driver.findElement(checkboxFinanceOverview).isDisplayed(), "The checkbox Finance Overview is not displayed.");
    }

    public void clickOnFinanceOverviewCheckbox() {
        WebUI.clickElement(checkboxFinanceOverview);
    }

    public void verifyUserWidgetCheckbox(String label) {
        Assert.assertTrue(driver.findElement(labelUserWidget).isDisplayed(), "The label User Widget is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelUserWidget), label, "The content of label User Widget is not matched.");
        Assert.assertTrue(driver.findElement(checkboxUserWidget).isDisplayed(), "The checkbox UserWidget is not displayed.");
    }

    public void clickOnUserWidgetCheckbox() {
        WebUI.clickElement(checkboxUserWidget);
    }

    public void verifyCalendarCheckbox(String label) {
        Assert.assertTrue(driver.findElement(labelCalendar).isDisplayed(), "The label Calendar is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelCalendar), label, "The content of label Calendar is not matched.");
        Assert.assertTrue(driver.findElement(checkboxCalendar).isDisplayed(), "The checkbox Calendar is not displayed.");
    }

    public void clickOnCalendarCheckbox() {
        WebUI.clickElement(checkboxCalendar);
    }

    public void verrifyPaymentRecordsCheckbox(String label) {
        Assert.assertTrue(driver.findElement(labelPaymentRecords).isDisplayed(), "The label Payment Records is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelPaymentRecords), label, "The content of label Payment Records is not matched.");
        Assert.assertTrue(driver.findElement(checkboxPaymentRecords).isDisplayed(), "The checkbox Payment Records is not displayed.");
    }
    public void clickOnPaymentRecordsCheckbox(){
        WebUI.clickElement(checkboxPaymentRecords);
    }

    public void verifyContractsExpiringSoonCheckbox(String label) {
        Assert.assertTrue(driver.findElement(labelContractsExpiringSoon).isDisplayed(), "The label Contracts Expiring Soon is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelContractsExpiringSoon), label, "The content of label Contracts Expiring Soon is not matched.");
        Assert.assertTrue(driver.findElement(checkboxContractsExpiringSoon).isDisplayed(), "The checkbox ContractsExpiringSoon is not displayed.");
    }
    public void clickOnContractsExpiringSoonCheckbox(){
        WebUI.clickElement(checkboxContractsExpiringSoon);
    }

    public void verifyMyToDoItemsCheckbox(String label) {
        Assert.assertTrue(driver.findElement(labelMyToDoItems).isDisplayed(), "The label My To Do Items is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelMyToDoItems), label, "The content of label My To Do Items is not matched.");
        Assert.assertTrue(driver.findElement(checkboxMyToDoItems).isDisplayed(), "The checkbox My To Do Items is not displayed.");
    }
    public void clickOnVerifyMyToDoItemsCheckbox(){
        WebUI.clickElement(checkboxMyToDoItems);
    }

    public void verifyLeadsChartCheckbox(String label) {
        Assert.assertTrue(driver.findElement(labelLeadschart).isDisplayed(), "The label Leads Chart is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelLeadschart), label, "The content of label Leads Chart is not matched.");
        Assert.assertTrue(driver.findElement(checkboxLeadsChart).isDisplayed(), "The checkbox Leads Chart is not displayed.");
    }
    public void clickOnLeadsChartCheckbox(){
        WebUI.clickElement(checkboxLeadsChart);
    }

    public void verifyProjectsChartCheckbox(String label) {
        Assert.assertTrue(driver.findElement(labelProjectsChart).isDisplayed(), "The label Projects Chart is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelProjectsChart), label, "The content of label Projects Chart is not matched.");
        Assert.assertTrue(driver.findElement(checkboxProjectsChart).isDisplayed(), "The checkbox Projects Chart is not displayed.");
    }
    public void clickOnProjectsChartCheckbox(){
        WebUI.clickElement(checkboxProjectsChart);
    }

    public void verifyLatestProjectActivityCheckbox(String label) {
        Assert.assertTrue(driver.findElement(labelLatestProjectActivity).isDisplayed(), "The label Latest Project Activity is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelLatestProjectActivity), label, "The content of label Latest Project Activity is not matched.");
        Assert.assertTrue(driver.findElement(checkboxLatestProjectActivity).isDisplayed(), "The checkbox Project Activity is not displayed.");
    }
    public void clickOnLatestProjectActivityCheckbox(){
        WebUI.clickElement(checkboxLatestProjectActivity);
    }

    //Total label and data inside

    public void verifyLabelInvoicesAwaitingPayment(String label){
        Assert.assertTrue(driver.findElement(labelInvoicesAwaitingPayment).isDisplayed(),"The label Invoices Awaiting Payment is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelInvoicesAwaitingPayment),label,"The content of label Invoices Awaiting Payment is not matched.");
    }
    public void verifyInvoicesAwaitingPaymentTotal(String total) {
        Assert.assertTrue(driver.findElement(totalInvoicesAwaitingPayment).isDisplayed(), "The Invoices Awaiting Payment total label is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(totalInvoicesAwaitingPayment), total, "The Invoices Awaiting Payment total is not matched.");
    }

    public void verifyLabelConvertedLeads(String label){
        Assert.assertTrue(driver.findElement(labelConvertedLeads).isDisplayed(),"The label Converted Leads is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelConvertedLeads),label,"The content of label Converted Leads is not matched.");
    }
    public void verifyConvertedLeadsTotal(String total) {
        Assert.assertTrue(driver.findElement(totalConvertedLeads).isDisplayed(), "The Converted Leads total label is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(totalConvertedLeads), total, "The Converted Leads total is not matched.");
    }


    public void verifyLabelProjectsInProgress(String label) {
        Assert.assertTrue(driver.findElement(labelProjectsInProgress).isDisplayed(),"The label Projects In Progresss is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelProjectsInProgress),label,"The content of label Projects In Progresss is not matched.");
    }
    public void verifyProjectsInProgressTotal(String total) {
        Assert.assertTrue(driver.findElement(totalProjectsInProgress).isDisplayed(), "The Projects In Progresss total is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(totalProjectsInProgress), total, "The Projects In Progresss total is not matched.");
    }

    public void verifyLabelTasksNotFinishedTotal(String label) {
        Assert.assertTrue(driver.findElement(labelTasksNotFinished).isDisplayed(),"The label Tasks Not Finished is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelTasksNotFinished),label,"The content of label Tasks Not Finished is not matched.");
    }

    public void verifyTasksNotFinishedTotal(String total) {
        Assert.assertTrue(driver.findElement(totalTasksNotFinished).isDisplayed(), "The Tasks Not Finished total label is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(totalTasksNotFinished), total, "The Tasks Not Finished total is not matched.");
    }

    //Invoice Overview
    public void verifyInvoiceOverview(String label) {
        Assert.assertTrue(driver.findElement(labelInvoiceOverview).isDisplayed(), "Label Invoice Overview is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelInvoiceOverview), label, "Label Invoice Overview is not matched.");
    }

    public void clickOnDrartInvoice() {
        WebUI.clickElement(textlinkInvoiceDraft);
    }

    public void clickOnNotSentInvoice(){
        WebUI.clickElement(textlinkInvoiceNotSent);
    }
    public void clickOnUnpaidInvoice(){
        WebUI.clickElement(textlinkInvoiceUnpaid);
    }
    public void clickOnPartiallyPaidInvoice(){
        WebUI.clickElement(textlinkInvoicePartiallyPaid);
    }
    public void clickOnOverDueInvoice(){
        WebUI.clickElement(textlinkInvoiceOverDue);
    }
    public void clickOnPaidInvoice(){
        WebUI.clickElement(textlinkInvoicePaid);
    }

    //Estimate Overview
    public void verifyEstimateOverview(String label){
        Assert.assertTrue(driver.findElement(labelEstimateOverview).isDisplayed(),"Label Estimate Overview is not dipslayed.");
        Assert.assertEquals(WebUI.getTextElement(labelEstimateOverview),label,"Label Estimate Overview is not matched.");
    }

    public void clickOnDraftEstimate(){
        WebUI.clickElement(textlinkEstimateDraft);
    }

    public void clickOnNotSentEstimate(){
        WebUI.clickElement(textlinkEstimateNotSent);
    }

    public void clickOnSentEstimate(){
        WebUI.clickElement(textlinkEstimateSent);
    }
    public void clickOnExpiredEstimate(){
        WebUI.clickElement(textlinkEstimateExpired);
    }

    public void clickOnDeclinedEstimate(){
        WebUI.clickElement(textlinkEstimateDeclined);
    }

    public void clickOnAcceptedEstimate(){
        WebUI.clickElement(textlinkEstimateAccepted);
    }

    //Proposal Overview
    public void verifyProposalOverview(String label){
        Assert.assertTrue(driver.findElement(labelProposalOverview).isDisplayed(),"Label Proposal Overview is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelProposalOverview),label,"Label Proposal Overview is not matched.");
    }

    public void clickOnDraftProposal(){
        WebUI.clickElement(textlinkProposalDraft);
    }

    public void clickOnSentProposal(){
        WebUI.clickElement(textlinkProposalSent);
    }

    public void clickOnOpenProposal(){
        WebUI.clickElement(textlinkProposalOpen);
    }

    public void clickOnRevisedProposal(){
        WebUI.clickElement(textlinkProposalRevised);
    }

    public void clickOnDeclinedProposal(){
        WebUI.clickElement(textlinkProposalDeclined);
    }
    public void clickOnAcceptedProposal(){
        WebUI.clickElement(textlinkProposalAccepted);
    }

    //InvoiceSummaryData
    public void verifyLabelOutStandingInvoices(String label){
        Assert.assertTrue(driver.findElement(labelOutstandingInvoices).isDisplayed(),"The label Outstanding Invoices is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(labelOutstandingInvoices),label,"The label Outstanding Invoices is not matched.");
    }
    public void verifyDataOutstandingInvoices(String total){
        Assert.assertTrue(driver.findElement(dataOutstandingInvoices).isDisplayed(),"The label data Outstanding Invoices is not displayed.");
        Assert.assertEquals(WebUI.getTextElement(dataOutstandingInvoices),total,"The data of Outstanding Invoices is not matched.");
    }


}
