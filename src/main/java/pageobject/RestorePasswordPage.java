package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RestorePasswordPage {
    private final WebDriver driver;

    private final static String restorePasswordPage = "https://stellarburgers.nomoreparties.site/forgot-password";
    //локатор для кнопки войти в форме востановления пароля
    private final By authLinkByRestorePassForm = By.xpath(".//h2[text()='Восстановление пароля']");

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    //открытие страницы
    @Step("Переход на страницу смены пароля")
    public void openRestorePage (){
        driver.get(restorePasswordPage);
    }

    //	вход через кнопку в форме восстановления пароля
    @Step("Сообщение Востановление пароля")
    public String clickAuthLinkByRestorePassForm (){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(authLinkByRestorePassForm));
        String text=driver.findElement(authLinkByRestorePassForm).getText();
    return text;
    }
}