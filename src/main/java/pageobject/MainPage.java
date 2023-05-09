package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {


    //  локатор для кнопки Войти
    private final By authorizationButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //  локатор для кнопки личный кабинет
    private final By userAccountButton = By.xpath("//a[@class='AppHeader_header__link__3D_hX' and @href='/account']");
    //  локаторы для соуса
    private final By ingredientSauceButton = By.xpath("//span[text()='Соусы']/..");
    private final By checkSauceDisplayed = By.xpath(".//section[1]/div[2]/h2[2]");
    //  локаторы для булки
    private final By ingredientBunsButton = By.xpath("//span[text()='Булки']/..");
    private final By  checkBunsDisplayed = By.xpath(".//section[1]/div[2]/h2[1]");
    // локаторы для начинки
    private final By ingredientFillingButton = By.xpath("//span[text()='Начинки']/..");
    private final By checkFillingDisplayed = By.xpath(".//section[1]/div[2]/h2[3]");
    // локаторы для кнопки "Оформить заказ"
    private final By designerText =By.xpath("//*[text()='Соберите бургер']");
    private final By orderButton = By.className("button_button__33qZ0");
    private  final By bunTextOnIngredientList= By.xpath(".class='BurgerIngredients_ingredients__menuContainer__Xu3Mo', [text()='Начинки']");
    private  final By sauceTextOnIngredientList= By.xpath(".class='BurgerIngredients_ingredients__menuContainer__Xu3Mo, [text()='Соусы']'");


    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //метод перехода на главную страницу
    @Step("Открытие главной страницы")
    public void openMainPage (){
        driver.get("https://stellarburgers.nomoreparties.site/");
    }
    //метод клика по кнопке Ленты Заказов
    // метод того что при нажатии ссылки соусов меню автоматически скролится до соусов
    @Step("Нажатие на Соусы")
    public boolean checkSauceLinkDisplayed() {
        driver.findElement(ingredientSauceButton).click();
        return driver.findElement(checkSauceDisplayed).isDisplayed();
    }

    // метод того что при нажатии ссылки соусов меню автоматически скролится до начинки
    @Step("Нажатие на Начинки")
    public boolean checkStuffingLinkDisplayed() {
        driver.findElement(ingredientFillingButton).click();
        return driver.findElement(checkFillingDisplayed).isDisplayed();
    }

    // метод того что при нажатии ссылки соусов меню автоматически скролится до булок
    @Step("Нажатие на ссылку 'Булочки' на главной странице")
    public boolean checkBunsLinkDisplayed() {
        driver.findElement(ingredientFillingButton).click(); //сначала выберем начинку, булки и так стартовые
        driver.findElement(ingredientBunsButton).click();
        return driver.findElement(checkBunsDisplayed).isDisplayed();
    }
    @Step("Нажимаем кнопку  Войти в личный кабинет")
    public void clickLogInYourAccountButton(){
        driver.findElement(userAccountButton).click();
    }
    @Step("Вытаскиваем текст 'Соберите бургер'")
    public String getDesignerText(){
        return driver.findElement(designerText).getText();
    }

    @Step("Вытаскиваем текст 'Оформить заказ'")
    public String textOrderButton () {
        return driver.findElement(orderButton).getText();
    }

}