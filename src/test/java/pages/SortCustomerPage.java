package pages;

import projectStorage.StorageString;
import io.qameta.allure.Step;
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

    private final WebDriver driver;

    public SortCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get(StorageString.url);
    }


    // Поиск элементов
    @FindBy(css = "[ng-click='showCust()']")
    private static WebElement MenuCustomer;

    @FindBy(xpath = "//*[@ng-click=\"sortType = 'fName'; sortReverse = !sortReverse\"]")
    private static WebElement SortCustomer;

    @FindBy(css = "tbody > tr > td:first-child")
    private List<WebElement> nameElements;


    // Логика заполнения формы

    @Step("Нажатие на кнопку \"Customers\"")
    public void clickMenuSortCustomer() {
        MenuCustomer.click();
    }

    @Step("Двойной клик на полю \"firstName\" для сортировки в алфавитном порядке")
    public void clickSortCustomer() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(SortCustomer));
        SortCustomer.click();
        SortCustomer.click();
    }


    // Метод для получения списка имён клиентов
    public List<String> getCustomerNames() {
        return nameElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
