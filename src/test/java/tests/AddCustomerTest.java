package tests;


import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import pages.AddCustomerPage;
import pages.SortCustomerPage;


import java.util.List;


public class AddCustomerTest extends TestBase {

    @Test
    @Step("Новый пользователь добавлен")
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
        Assertions.assertEquals(customerNames.size(), extendedCustomerNames.size() - 1);
    }


    @Test
    @Step("Длина почтового индекса 10 знаков")
    @DisplayName("Проверка длины почтового индекса")
    public void generatePostCodeTest() {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        String postCode = addCustomerPage.generatePostCode();
        Assertions.assertEquals(postCode.length(), 10);
    }


    @Test
    @Step("Длина имени 5 знаков")
    @DisplayName("Проверка длины имени")
    public void generateFirstNameTest() {
        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        String postCode = addCustomerPage.generatePostCode();
        String firstName = addCustomerPage.generateFirstName(postCode);
        Assertions.assertEquals(firstName.length(), 5);
    }

}








