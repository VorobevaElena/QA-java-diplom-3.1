package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPage {
    private final WebDriver driver;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    //  локатор для поля Email
    private final By emailField = By.xpath("//input[@name='name']");
    //  локатор для поля Пароль
    private final By passwordField = By.xpath("//input[@type='password']");
    //  локатор для кнопки Войти
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    //  локатор для кнопки Зарегистрироваться
    private final By registerButton = By.xpath("//*[text()='Зарегистрироваться']");

    //метод авторизации
    @Step("Заполнение формы авторизации")
    public void authorization (String email, String password){
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    //проверка текста на кнопке Войти
    @Step("Получение текста кнопки авторизации на странице авторизации")
    public String checkLoginButton () {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(loginButton));
    return driver.findElement(loginButton).getText();
    }
    @Step("Нажимаем кнопку регистрация")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
}