package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import projectStorage.StorageString;

import java.util.List;
import java.util.stream.Collectors;


public class DeleteCustomerPage {
    private final WebDriver driver;

    // Поиск элементов
    @FindBy(css = "[ng-click='showCust()']")
    private WebElement MenuCustomers;
    @FindBy(xpath = "//table//tbody//tr/td[1]")
    private List<WebElement> nameElements;

    public DeleteCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get(StorageString.URL);
    }

    public void clickMenuSortCustomer() {
        MenuCustomers.click();
    }


    // Метод для получения списка имён клиентов
    public List<String> getCustomerNames() {
        return nameElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Поиск нужного клиента")
    // Метод для нахождения имени клиента, который будет удалён
    public String nameToDelete(List<String> names) {

        int average = (int) nameElements.stream()
                .map(webElement -> webElement.getText())
                .mapToInt(text -> text.length())
                .average()
                .orElse(0);

        String nameToDelete = "";
        int smallestDifference = Integer.MAX_VALUE;

        // Поиск имени с длиной, близкой к средней
        for (String name : names) {
            int lengthDifference = Math.abs(name.length() - average);

            // Если текущая разница меньше предыдущей минимальной разницы, запоминаем это имя
            if (lengthDifference < smallestDifference) {
                smallestDifference = lengthDifference;
                nameToDelete = name;
            }
        }
        return nameToDelete;
    }

    public WebElement findButtonDelete(String nameToDelete) {
        return driver.findElement(By.xpath("//td[text()='" + nameToDelete + "']/following-sibling::td/button[contains(text(),'Delete')]"));
    }

    @Step("Удаление клиента")
    public void clickDeleteName(String nameToDelete) {
        findButtonDelete(nameToDelete).click();
    }


}