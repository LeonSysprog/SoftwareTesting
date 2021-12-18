import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;

import java.time.Duration;

public class TestMVideo {
    @Test
    @Description("Catalog - change min cost")
    @Severity(SeverityLevel.TRIVIAL)
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mvideo.ru/noutbuki-planshety-komputery-8/noutbuki-118?reff=menu_main");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement cost = driver.findElement(By.xpath("//input[@name = \"minPrice\"]"));
        cost.sendKeys("111111");
        cost.sendKeys(Keys.ENTER);
        cost.sendKeys(Keys.BACK_SPACE);

        // Setting Assert
        Assert.assertSame("111 111", cost.getAttribute("placeholder"));
    }

    @Test
    @Description("Registration - not all fields are filled in")
    @Severity(SeverityLevel.TRIVIAL)
    public void test2() {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mvideo.ru/register");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement email = driver.findElement(By.xpath("//input[@id = \"legal-frm-name-input\"]"));
        email.sendKeys("111111111");

        WebElement agree = driver.findElement(By.xpath("//label[@for = \"form-register-legalterms\"]"));
        agree.click();

        WebElement registrationButton = driver.findElement(By.xpath("//input[@value = \"Зарегистрироваться\"]"));
        registrationButton.click();

        Assert.assertTrue(registrationButton.isEnabled());
    }

    @Test
    @Description("Shopping - add and remove product from basket")
    @Severity(SeverityLevel.TRIVIAL)
    public void test3() {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mvideo.ru/cart");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement buttonAdd = driver.findElement(By.xpath("//button[@class = \"i-icon-fl-cart add-to-basket-button btn c-btn c-btn_icon add-to-basket-button c-btn_small c-btn_text c-btn_text-hidden-mobile i-icon-fl-cart submit-basket\"]"));

        //System.out.println("Add product");
        buttonAdd.click();

        //System.out.println("buttonBasket");
        WebElement buttonBasket = driver.findElement(By.xpath("//a[@class = \"c-btn c-btn_text c-btn_redirect u-mt-16 u-mt-xs-20 u-ml-12 c-popup-add-to-basket__btn\"]"));
        buttonBasket.click();

        //System.out.println("count");
        WebElement count = driver.findElement((By.xpath("//div[@class = \"c-cost-line__title-wrap\"]")));
        String countText = count.getText();

        //System.out.println("editBasket");
        WebElement editBasket = driver.findElement(By.xpath("//a[. = \"Удалить\"]"));
        editBasket.click();

        //System.out.println("buttonAgreeRemove");
        WebElement buttonAgreeRemove = driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/a"));
        buttonAgreeRemove.click();

        //System.out.println("emptyBasket");
        WebElement emptyBasket = driver.findElement(By.xpath("//div[@class = \"c-cart__empty-title\"]"));
        String emptyBasketText = emptyBasket.getText();

        Assert.assertTrue(emptyBasketText.equals("Ваша корзина пока пуста") && countText.equals("В корзине 1 товар"));
    }
}
