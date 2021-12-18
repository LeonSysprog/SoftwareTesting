import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;

import java.time.Duration;

public class TestOzon {
    @Test
    @Description("DeliveryCheckbox")
    @Severity(SeverityLevel.TRIVIAL)
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ozon.ru/category/sistemnye-bloki-15704/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement cost = driver.findElement(By.xpath("//input[@class = \"ui-g0 ui-g1 ui-a6a\"]"));
        cost.sendKeys("37");

        WebElement sales = driver.findElement(By.className("//div[@value = \"Скидки декабря\"]"));
        sales.click();
        // Setting Assert
        Assert.assertTrue(sales.isDisplayed());
    }

    @Test
    @Description("Registration")
    @Severity(SeverityLevel.TRIVIAL)
    public void test2() {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ozon.ru/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement registration = driver.findElement(By.xpath("//span[span = \"Вход или регистрация\"]"));
        registration.click();

        // WebElement delay = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(registration));

        // driver.switchTo().parentFrame();

        /**
        for (int i = 0; i < 4; ++i) {
            driver.switchTo().frame(i);
            int phoneSize = driver.findElements(By.xpath("//span[span = \"Получить код\"]")).size();
            if (phoneSize > 0) {
                WebElement phone = driver.findElement(By.xpath("//span[span = \"Получить код\"]"));
                phone.click();
                break;
            }
            driver.switchTo().defaultContent();
        }
         **/

        Assert.assertTrue(registration.isDisplayed());
    }
}
