package pageobject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountTest {
    private WebDriver driver;
    MainPage mainPage;
    AuthorizationPage authorizationPage;
    AccountPage accountProfilePage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        // System.setProperty("webdriver.chrome.driver","C:/WebDriver/bin/chromedriver.exe");//Yandex
        ChromeOptions options = new ChromeOptions();
        // options.setBinary(System.getenv("C:/Users/User/AppData/Local/Yandex/YandexBrowser/Application/browser.exe"));
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage = new MainPage(driver);
        mainPage.clickLogInYourAccountButton();
        authorizationPage = new AuthorizationPage(driver);
        authorizationPage.authorization("yankina.elena.nso@ya.ru", "123Stellar");
        accountProfilePage = new AccountPage(driver);
    }

    @After
    public void teardown() {

         driver.quit();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void exitLoginTest() {
        mainPage.clickLogInYourAccountButton();
        accountProfilePage.clickExitButton();
         String newGetEnterText = authorizationPage.checkLoginButton();
        assertThat(newGetEnterText, is("Войти"));
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор ")
    public void transitionConstructorTest() {
        accountProfilePage.clickConstructorButton();
        String newDesignerText = mainPage.getDesignerText();
        assertThat(newDesignerText, is("Соберите бургер"));
    }

    @Test
    @DisplayName("Переход из личного кабинета  по Stellar Burgers в конструктор ")
    public void stellarBurgersTest() {
        accountProfilePage.clickConstructorButton();
        String newDesignerText = mainPage.getDesignerText();
        assertThat(newDesignerText, is("Соберите бургер"));
    }

}