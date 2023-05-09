package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    private final WebDriver driver;
    public final By accountLink = By.xpath("//*[text()='Профиль']");
    public final By accountOrder = By.xpath("//*[text()='История заказов']");
    private final By logoutButton = By.xpath("//button[text()='Выход']");
    private final By logoButton = By.className("AppHeader_header__logo__2D0X2");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }


    //	выход из аккаунта через кнопку 'выход' в личном кабинете
    @Step("Нажмитие кнопки выхода в личном кабинете")
    public void clickExitButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
    }

    //	переход на главную страницу через символ логотипа в личном кабинете
    @Step("Нажмитие на логотип в личном кабинете")
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }

    //	переход в раздел конструктор на главной странице через ссылку в личном кабинете
    @Step("Нажатие кнопки Конструктор в личном кабинете")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Ожидание кнопки 'Stellar Burgers'")
    public String checkLogInPersonalAccount() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(logoutButton));
        return driver.findElement(logoutButton).getText();
    }
    @Step("Ожидание кнопки 'Профиль'")
    public boolean expectationAccount() {
        return driver.findElement(accountLink).isDisplayed();
    }


}