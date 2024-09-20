package tests;


import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import pages.AddCustomerPage;
import pages.SortCustomerPage;

import java.util.List;


public class AddCustomerTest extends TestBase {
    @Test
    @Step
    @DisplayName("Проверка алгоритма заполнение полей 'First Name', 'Post Code'")
    public void addCustomerTest() {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        String postCode = addCustomerPage.generatePostCode();
        String firstName = addCustomerPage.generateFirstName(postCode);
        addCustomerPage.clickMenuButtonAddCustomer();
        addCustomerPage.inputFirstName(firstName);
        addCustomerPage.inputLastName("TestLastName");
        addCustomerPage.inputPostCode(postCode);
        addCustomerPage.clickSubmitAddCustomer();
    }


    @Test
    @Step
    @DisplayName("Проверка длинны 'PostCode' == 10 ")
    public void generatePostCodeTest() {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        String postCode = addCustomerPage.generatePostCode();
        Assert.assertEquals(postCode.length(), 10);
    }


    @Test
    @Step
    @DisplayName("Проверка длинны 'FirstName' == 5")
    public void generateFirstNameTest() {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        String postCode = addCustomerPage.generatePostCode();
        String firstName = addCustomerPage.generateFirstName(postCode);
        Assert.assertEquals(firstName.length(), 5);
    }


    @Test
    @Step
    @DisplayName("Проверка добавления нового пользователя")
    public void addUserCustomerTest() {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        SortCustomerPage sortCustomerPage = new SortCustomerPage(driver);
        String postCode = addCustomerPage.generatePostCode();
        String firstName = addCustomerPage.generateFirstName(postCode);
        sortCustomerPage.clickMenuSortCustomer();
        List<String> customerNames = sortCustomerPage.getCustomerNames();
        addCustomerPage.clickMenuButtonAddCustomer();
        addCustomerPage.inputFirstName(firstName);
        addCustomerPage.inputLastName("TestLastName");
        addCustomerPage.inputPostCode(postCode);
        addCustomerPage.clickSubmitAddCustomer();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        sortCustomerPage.clickMenuSortCustomer();
        List<String> extendedCustomerNames = sortCustomerPage.getCustomerNames();
        Assert.assertEquals(customerNames.size(), extendedCustomerNames.size() - 1);
    }

}








