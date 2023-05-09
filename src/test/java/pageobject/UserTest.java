package pageobject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import user.User;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
public class UserTest
{
    private RegistrationPage registrationPage;
    private AuthorizationPage authorizationPage;
    private MainPage mainPage;
    private WebDriver driver;
    private String name;
    private String email;
    private String password;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        // System.setProperty("webdriver.chrome.driver","C:/WebDriver/bin/chromedriver.exe");//Yandex
        ChromeOptions options = new ChromeOptions();
        // options.setBinary(System.getenv("C:/Users/User/AppData/Local/Yandex/YandexBrowser/Application/browser.exe"));
        driver = new ChromeDriver(options);          User user = new User();
        name = user.getRandomName();
        email = user.getRandomEmail();
        password = user.getRandomPassword();
        registrationPage = new RegistrationPage(driver);// создание объекта класса страницы регистрации
        registrationPage.openRegPage();
        registrationPage.createNewUser(name,email,password);
        authorizationPage = new AuthorizationPage(driver);
        mainPage = new MainPage(driver);// создание объекта класса main страницы
    }

    @After
    public void teardown() {
       driver.quit();
    }

    @Test
    @DisplayName("Проверка входа в Личный кабинет")
    public void checkPersonalAccountLinkTest() {
        authorizationPage.authorization(email, password);
        mainPage.clickLogInYourAccountButton();
        AccountPage userAccountPage = new AccountPage(driver);
        assertEquals("Проверка входа в Личный кабинет", "Выход", userAccountPage.checkLogInPersonalAccount());
    }

    @Test
    @DisplayName("Выход из аккаунта по ссылке в Личном кабинете")
    public void checkExitButtonTest() {
        authorizationPage.authorization(email, password);
        mainPage.clickLogInYourAccountButton();
        AccountPage objPersonalAccountPage = new AccountPage(driver);
        objPersonalAccountPage.clickExitButton();
        assertEquals("Выход из аккаунта", "Войти", authorizationPage.checkLoginButton());
    }

    @Test
    @DisplayName("Переход на главную страницу по логотипу в Личном кабинете")
    public void checkLogoButtonTest() {
        authorizationPage.authorization(email, password);
        mainPage.clickLogInYourAccountButton();
        AccountPage personalAccountPage = new AccountPage(driver);
        personalAccountPage.clickLogoButton();
        assertEquals("Переход на главную страницу через логотип", "Оформить заказ", mainPage.textOrderButton());
    }

    @Test
    @DisplayName("Переход на главную страницу с помощью кнопки Конструктора в Личном кабинете")
    public void checkConstructorButtonTest() {
        authorizationPage.authorization(email, password);
        mainPage.clickLogInYourAccountButton();
        AccountPage objPersonalAccountPage = new AccountPage(driver);
        objPersonalAccountPage.clickConstructorButton();
        assertEquals("Переход на главную страницу через Конструктор", "Оформить заказ", mainPage.textOrderButton());
    }
}
