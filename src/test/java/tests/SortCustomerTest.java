package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import pages.SortCustomerPage;
import org.junit.jupiter.api.DisplayName;

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
        Assertions.assertEquals(sortedNames, customerNames);
    }
}



