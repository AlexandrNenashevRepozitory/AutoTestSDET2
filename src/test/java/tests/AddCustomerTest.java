package tests;


import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import pages.AddCustomerPage;
import pages.SortCustomerPage;
import projectStorage.StorageString;

import java.util.List;


public class AddCustomerTest extends TestBase {

    private static AddCustomerPage addCustomerPage;

    @BeforeAll
    public static void setAddCustomer() {
        addCustomerPage = new AddCustomerPage(driver);
    }


    @Test
    @Step("Новый пользователь добавлен")
    @DisplayName("Проверка добавления нового пользователя")
    public void addUserCustomerTest() {
        SortCustomerPage sortCustomerPage = new SortCustomerPage(driver);
        String postCode = addCustomerPage.generatePostCode();
        String firstName = addCustomerPage.generateFirstName(postCode);
        sortCustomerPage.clickMenuSortCustomer();
        List<java.lang.String> customerNames = sortCustomerPage.getCustomerNames();
        addCustomerPage.clickMenuButtonAddCustomer();
        addCustomerPage.inputFirstName(firstName);
        addCustomerPage.inputLastName(StorageString.LAST_NAME);
        addCustomerPage.inputPostCode(postCode);
        addCustomerPage.clickSubmitAddCustomer();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        sortCustomerPage.clickMenuSortCustomer();
        List<java.lang.String> extendedCustomerNames = sortCustomerPage.getCustomerNames();
        Assertions.assertEquals(customerNames.size(), extendedCustomerNames.size() - 1);
    }


    @Test
    @Step("Длина почтового индекса 10 знаков")
    @DisplayName("Проверка длины почтового индекса")
    public void generatePostCodeTest() {
        String postCode = addCustomerPage.generatePostCode();
        Assertions.assertEquals(postCode.length(), 10);
    }


    @Test
    @Step("Длина имени 5 знаков")
    @DisplayName("Проверка длины имени")
    public void generateFirstNameTest() {
        String postCode = addCustomerPage.generatePostCode();
        String firstName = addCustomerPage.generateFirstName(postCode);
        Assertions.assertEquals(firstName.length(), 5);
    }

}








