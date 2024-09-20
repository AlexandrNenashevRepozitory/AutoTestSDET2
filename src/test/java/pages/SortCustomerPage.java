package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.time.Duration;
import java.util.stream.Collectors;


public class SortCustomerPage {

    private final WebDriver driver;  // Локальная переменная для WebDriver

    // Конструктор принимает WebDriver и инициализирует элементы страницы
    public SortCustomerPage(WebDriver driver) {
        this.driver = driver;  // Инициализация локальной переменной
        PageFactory.initElements(driver, this);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
    }


    // Поиск элементов
    @FindBy(css = "[ng-click='showCust()']")
    private static WebElement MenuCustomer;

    @FindBy(xpath = "//*[@ng-click=\"sortType = 'fName'; sortReverse = !sortReverse\"]")
    private static WebElement SortCustomer;

    @FindBy(css = "tbody tr td:nth-child(1)") // Первый столбец таблицы (имена)
    private List<WebElement> customerNameElements;


    // Логика заполнения формы
    public void clickMenuSortCustomer() {
        MenuCustomer.click();
    }

    public void clickSortCustomer() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));  // Ожидание до 10 секунд
        wait.until(ExpectedConditions.elementToBeClickable(SortCustomer));
        SortCustomer.click();
        SortCustomer.click();
    }


    // Метод для получения списка имён клиентов
    public List<String> getCustomerNames() {
        return customerNameElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
