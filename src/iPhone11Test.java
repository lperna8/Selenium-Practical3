
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class iPhone11Test {
    String Rating;
    String AddToCart;
    WebDriver driver;
    String TotalAmount;

    @Test(priority = 1)
    public void Amazon() {

        System.setProperty("webdriver.chrome.driver", "/Users/lperna/Downloads/Drivers/New/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://www.amazon.com/");
        System.out.println("This is test");

    }

    @Test(priority = 2)
    public void Search() {
        driver.findElement(By.id("twotabsearchtextbox")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone 11");
        driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@type='submit']")).click();

    }

    @Test(priority = 3)
    public void Select() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='a-section a-spacing-top-medium s-visual-card-navigation-desktop']//img[@alt='iPhone 11 Pro']")).click();

        System.out.println("iPhone results");
    }


    @Test(priority = 4)
    public void ComparisionChart() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> compchart = driver.findElements(By.xpath("//div[@id='comparison-chart']"));

        if (compchart.size() > 0) {
            System.out.println("Comparison chart available");
        } else {
            System.out.println("Comparison chart not available");
        }

    }

    @Test(priority = 5)
    public void Rating() {
        Rating = driver.findElement(By.xpath("//div[@class='a-section a-spacing-mini a-spacing-top-mini aok-inline-block']//*[@class='a-icon-alt']")).getAttribute("innerText");
        System.out.println(Rating);
    }

    @Test(priority = 6)
    public void AddToCart() {
        driver.findElement(By.xpath("//span[@text='Add to Cart']")).click();
    }

    @Test(priority = 7)
    public void TotalAmount() {

        driver.findElement(By.xpath("//div[@class='a-box a-color-alternate-background decisionBoxOffset']//span[@class='a-button qa-warranty-no-thanks-button']//button[@class='a-button-text']")).click();
        TotalAmount = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-price a-text-bold']")).getAttribute("innerText");
        System.out.println(TotalAmount);
    }

}

