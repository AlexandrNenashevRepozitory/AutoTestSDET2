package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;


public class DeleteCustomerPage {

    private final WebDriver driver; // Локальная переменная для WebDriver


    // Конструктор принимает WebDriver и инициализирует элементы страницы
    public DeleteCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
    }


    // Поиск элементов
    @FindBy(css = "[ng-click='showCust()']")
    private WebElement MenuCustomers;

    // Список элементов с именами клиентов (первый столбец)
    @FindBy(css = "tbody tr td:nth-child(1)")
    private List<WebElement> NameElements;

    // Первый столбец таблицы Customers
    @FindBy(css = "tbody tr td:nth-child(1)") // Первый столбец таблицы (имена)
    private List<WebElement> customerNameElements;


    public void clickMenuSortCustomer() {
        MenuCustomers.click();
    }


    // Метод для получения списка имён клиентов
    public List<String> getCustomerNames() {
        return customerNameElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    // Метод для нахождения имени клиента, который будет удалён
    public String nameToDelete(List<String> names) {

        int average = (int) NameElements.stream()
                .map(webElement -> webElement.getText())
                .mapToInt(text -> text.length())
                .average()
                .orElse(0);

        String nameToDelete = "";      // Переменная для хранения имени, которое будем удалять
        int smallestDifference = Integer.MAX_VALUE;     // Изначально задаём максимальную разницу

        // Поиск имени с длиной, близкой к средней
        for (String name : names) {
            int lengthDifference = Math.abs(name.length() - average);  // Вычисляем разницу длины имени со средним значением

            // Если текущая разница меньше предыдущей минимальной разницы, запоминаем это имя
            if (lengthDifference < smallestDifference) {
                smallestDifference = lengthDifference;  // Обновляем минимальную разницу
                nameToDelete = name;  // Запоминаем имя для удаления
            }
        }
        return nameToDelete;  // Возвращаем имя, которое будет удалено
    }


    // Поиск строки для удаления
    public WebElement findButtonDelete(String nameToDelete) {
        return driver.findElement(By.xpath("//td[text()='" + nameToDelete + "']/following-sibling::td/button[contains(text(),'Delete')]"));
    }


    // Удаление строки
    public void clickDeleteName(String nameToDelete) {
        findButtonDelete(nameToDelete).click();
    }


}