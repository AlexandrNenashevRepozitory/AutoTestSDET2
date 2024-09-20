package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;


public class AddCustomerPage {

    private final WebDriver driver; // Локальная переменная для WebDriver


    // Конструктор принимает WebDriver и инициализирует элементы страницы
    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
    }


    // Поиск элементов
    @FindBy(xpath = "//*[@ng-click='addCust()']")
    private static WebElement ButtonMenuAddCustomer;

    @FindBy(xpath = "//*[@placeholder=\"First Name\"]")
    private static WebElement FirstName;

    @FindBy(xpath = "//*[@placeholder=\"Last Name\"]")
    private static WebElement LastName;

    @FindBy(xpath = "//*[@placeholder=\"Post Code\"]")
    private static WebElement PostCode;

    @FindBy(css = "button[type='submit']")
    private static WebElement SubmitAddCustomer;


    // Логика заполнения формы
    public void clickMenuButtonAddCustomer() {
        ButtonMenuAddCustomer.click();
    }

    public void inputFirstName(String firstName) {
        FirstName.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        LastName.sendKeys(lastName);
    }
    public void inputPostCode(String postCode) {
        PostCode.sendKeys(postCode);
    }

    public void clickSubmitAddCustomer() {
        SubmitAddCustomer.click();
    }


    // Генерация числа для поля PostCode
    public String generatePostCode() {
        StringBuilder postCode = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i <= 9; i++) {
            int number = r.nextInt(9);
            postCode.append(number);
            System.out.println(postCode);
        }
        return postCode.toString();
    }


    // Генерация имени для поля FirstName
    public String generateFirstName(String postCode) {
        StringBuilder firstName = new StringBuilder();
        for (int i = 0; i < postCode.length(); i += 2) {
            int digit = Integer.parseInt(postCode.substring(i, i + 2)) % 26;
            firstName.append((char) ('a' + digit));
            System.out.println(firstName);
        }
        return firstName.toString();
    }
}