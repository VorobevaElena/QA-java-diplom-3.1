package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegistrationPage {
    private final WebDriver driver;
    //локатор для поля имя
    private final By userField = By.xpath("//label[contains(text(),'Имя')]/../input");
    //локатор для поля Email
    private final By emailField = By.xpath("//label[contains(text(),'Email')]/../input");
    //локатор для поля пароль
    private final By passwordField = By.xpath("//input[@type='password']");
    //локатор для кнопки регистрации
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    //локатор для текста ошибки
    private final By errorMessageText = By.xpath(".//p[text()='Некорректный пароль']");
    //локатор для кнопки войти в форме регистрации
    private final By authLinkByRegForm = By.xpath( ".//a[text()='Войти']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы регистрации")
    public void openRegPage (){
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    //создание юзера и регистрация
    @Step("Заполнение формы регистрации")
    public void createNewUser(String name, String email, String password) {
        driver.findElement(userField).clear();
        driver.findElement(userField).sendKeys(name);
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(registrationButton).click();
    }

    //	вход через кнопку в форме регистрации
    @Step("Find And Click Authorization Link on registration Page")
    public void clickAuthLinkByRegForm (){
        driver.findElement(authLinkByRegForm).click();
    }

    // отображение сообщения об ошибке пароля
    @Step("Find Error Message at registration form, check Error Message")
    public boolean getErrorMessage () {
        return driver.findElement(errorMessageText).isDisplayed();
    }

    // текст ошибки
    @Step("Find And get Error Message text")
    public String getTextErrorMessage () {
        return driver.findElement(errorMessageText).getText();
    }
    @Step("метод для заполения поля email")
    public void setDataEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    @Step("метод для заполения поля имя")
    public void setDataName(String name) {
        driver.findElement(userField).sendKeys(name);
    }
    @Step("метод для заполения поля password")
    public void setDataPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Нажимаем кнопку регистрация")
    public void clickRegisterButton() {
        driver.findElement(registrationButton).click();
    }
    @Step("Регитсрация")
    public void registerMethods(String name, String email, String password) {
        setDataName(name);
        setDataEmail(email);
        setDataPassword(password);
        clickRegisterButton();
    }


}
