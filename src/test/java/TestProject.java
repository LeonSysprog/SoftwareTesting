import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;
import java.util.function.BooleanSupplier;

public class TestProject {
    public static boolean ticketFunction(int []arr) {
        return arr[0] + arr[1] + arr[2] == arr[3] + arr[4] + arr[5];
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mvideo.ru/cart");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement buttonAdd = driver.findElement(By.xpath("//button[@class = \"i-icon-fl-cart add-to-basket-button btn c-btn c-btn_icon add-to-basket-button c-btn_small c-btn_text c-btn_text-hidden-mobile i-icon-fl-cart submit-basket\"]"));

        System.out.println("Add product");
        buttonAdd.click();

        System.out.println("buttonBasket");
        WebElement buttonBasket = driver.findElement(By.xpath("//a[@class = \"c-btn c-btn_text c-btn_redirect u-mt-16 u-mt-xs-20 u-ml-12 c-popup-add-to-basket__btn\"]"));
        buttonBasket.click();

        System.out.println("count");
        WebElement count = driver.findElement((By.xpath("//div[@class = \"c-cost-line__title-wrap\"]")));
        String countText = count.getText();

        System.out.println("editBasket");
        WebElement editBasket = driver.findElement(By.xpath("//a[. = \"Удалить\"]"));
        editBasket.click();

        System.out.println("buttonAgreeRemove");
        WebElement buttonAgreeRemove = driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/a"));
        buttonAgreeRemove.click();

        System.out.println("emptyBasket");
        WebElement emptyBasket = driver.findElement(By.xpath("//div[@class = \"c-cart__empty-title\"]"));
        String emptyBasketText = emptyBasket.getText();

        System.out.println("Complete");
    }
}
