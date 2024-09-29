package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import projectStorage.StorageString;

import java.util.Random;


public class AddCustomerPage {

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

    public AddCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.get(StorageString.URL);
    }

    // Логика заполнения формы
    @Step("Нажатие на кнопку \"Add Customer\"")
    public void clickMenuButtonAddCustomer() {
        ButtonMenuAddCustomer.click();
    }

    @Step("Заполнение поля \"First Name\"")
    public void inputFirstName(String firstName) {
        FirstName.sendKeys(firstName);
    }

    @Step("Заполнение поля \"Last Name\"")
    public void inputLastName(String lastName) {
        LastName.sendKeys(lastName);
    }

    @Step("Заполнение поля \"Post Code\"")
    public void inputPostCode(String postCode) {
        PostCode.sendKeys(postCode);
    }

    @Step("Нажатие на кнопку \"Add Customer\" (Submit)")
    public void clickSubmitAddCustomer() {
        SubmitAddCustomer.click();
    }


    @Step("Герация случайного PostCode")
    public String generatePostCode() {
        StringBuilder postCode = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i <= 9; i++) {
            int number = r.nextInt(9);
            postCode.append(number);
        }
        return postCode.toString();
    }


    @Step("Генерация FirstName")
    public String generateFirstName(String postCode) {
        StringBuilder firstName = new StringBuilder();
        for (int i = 0; i < postCode.length(); i += 2) {
            int digit = Integer.parseInt(postCode.substring(i, i + 2)) % 26;
            firstName.append((char) ('a' + digit));
        }
        return firstName.toString();
    }
}