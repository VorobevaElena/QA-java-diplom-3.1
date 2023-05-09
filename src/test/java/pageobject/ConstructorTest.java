package pageobject;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.MatcherAssert.assertThat;

public class ConstructorTest {
    private MainPage mainPage;

    private WebDriver driver;

    @Before
    public void optionBrowser() {
        WebDriverManager.chromedriver().setup();
       // System.setProperty("webdriver.chrome.driver","C:/WebDriver/bin/chromedriver.exe");//Yandex
        ChromeOptions options = new ChromeOptions();
        // options.setBinary(System.getenv("C:/Users/User/AppData/Local/Yandex/YandexBrowser/Application/browser.exe"));
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
        mainPage = new MainPage( driver);
    }

    @Test
    @Description ("При нажатии на вкладку Соусы, в блоке с ингридиентами список перемещается к соусам")
    public void goToSauceTest () {
      assertThat("соусы", mainPage.checkSauceLinkDisplayed() );
    }
    @Test
    @DisplayName("При нажатии на вкладку Соусы, в блоке с ингридиентами список перемещается к булочкам")
    public void navigateToSauceIngredientTest() {
        assertThat("булки", mainPage.checkBunsLinkDisplayed()) ;

    }

    @Test
    @DisplayName("При нажатии на вкладку Соусы, в блоке с ингридиентами список перемещается к начинок")
    public void navigateToFillingIngredientTest() {
        assertThat("начинка", mainPage.checkBunsLinkDisplayed()) ;
    }
    @After
    public void end(){
driver.quit();
    }
}
