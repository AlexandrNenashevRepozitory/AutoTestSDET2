package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import pages.DeleteCustomerPage;
import pages.SortCustomerPage;

import java.util.List;

public class DeleteCustomerTest extends TestBase {

    @Test
    @Step("Пользователь удалён")
    @DisplayName("Проверка удаления пользователя")
    public void deleteCustomerUserTest() {
        DeleteCustomerPage deleteCustomerPage = new DeleteCustomerPage(driver);
        SortCustomerPage sortCustomerPage = new SortCustomerPage(driver);
        deleteCustomerPage.clickMenuSortCustomer();
        List<String> customerNames = deleteCustomerPage.getCustomerNames();
        String nameToDelete = deleteCustomerPage.nameToDelete(customerNames);
        deleteCustomerPage.clickDeleteName(nameToDelete);
        List<String> extendedCustomerNames = deleteCustomerPage.getCustomerNames();
        Assertions.assertEquals(customerNames.size(), extendedCustomerNames.size() + 1);
    }
}