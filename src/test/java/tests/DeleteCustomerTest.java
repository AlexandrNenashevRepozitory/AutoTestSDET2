package tests;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
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
        Assert.assertEquals(customerNames.size(), extendedCustomerNames.size() + 1);
    }


}