package tests;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.SortCustomerPage;

import java.util.List;
import java.util.stream.Collectors;

public class SortCustomerTest extends TestBase {

    @Test
    @Step("Список клиентов отсортирован по имени")
    @DisplayName("Проверка сортировки клиентов по имени в таблице Customers")
    public void checkSortAlphabet() {
        SortCustomerPage sortCustomerPage = new SortCustomerPage(driver);
        sortCustomerPage.clickMenuSortCustomer();
        sortCustomerPage.clickSortCustomer();
        List<String> customerNames = sortCustomerPage.getCustomerNames();
        List<String> sortedNames = customerNames.stream()
                .sorted()
                .collect(Collectors.toList());
        Assert.assertEquals("Список клиентов не отсортирован по имени", sortedNames, customerNames);
    }
}



