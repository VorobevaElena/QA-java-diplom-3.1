
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.RestorePasswordPage;
import user.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;
import pageobject.AuthorizationPage;
import pageobject.RegistrationPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegistrationTest {
    private WebDriver driver;
    User user;
    MainPage homePage;
    RegistrationPage registerPage;
    AuthorizationPage loginPage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        // System.setProperty("webdriver.chrome.driver","C:/WebDriver/bin/chromedriver.exe");//Yandex
        ChromeOptions options = new ChromeOptions();
        // options.setBinary(System.getenv("C:/Users/User/AppData/Local/Yandex/YandexBrowser/Application/browser.exe"));
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
        homePage = new MainPage(driver);
        homePage.clickLogInYourAccountButton();
        loginPage = new AuthorizationPage(driver);
        loginPage.clickRegisterButton();
        registerPage = new RegistrationPage(driver);

    }

    @After
    public void teardown() {
  driver.quit();
    }

    @Test
    @DisplayName("Регистрация c некорректный паролем")
    public void createUserErrorTest() {
        registerPage.registerMethods("Shrek", "31@example.com", "1234");
        String newGetErrorText = registerPage.getTextErrorMessage();
        assertThat(newGetErrorText, is("Некорректный пароль"));
    }

    @Test
    @DisplayName("Регистрация")
    public void createUserTest() {
        User user = new User();
       registerPage.registerMethods(user.getRandomName(), user.getRandomEmail(), user.getRandomPassword());
        String newGetEnterText = loginPage.checkLoginButton();
        assertThat(newGetEnterText, is("Войти"));
    }
    @Test
    @DisplayName("Login user by forgot password page")
    public void loginUserByForgotPasswordPage() {
       RestorePasswordPage restorePasswordPage =new RestorePasswordPage(driver);
       restorePasswordPage.openRestorePage();
       restorePasswordPage.clickAuthLinkByRestorePassForm();
        restorePasswordPage.clickAuthLinkByRestorePassForm();

        assertThat( restorePasswordPage.clickAuthLinkByRestorePassForm(), is("Восстановление пароля"));
    }
}