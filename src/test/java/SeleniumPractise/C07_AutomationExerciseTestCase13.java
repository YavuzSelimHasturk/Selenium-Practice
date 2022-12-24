package SeleniumPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_AutomationExerciseTestCase13 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //2. Verify that home page is visible successfully
        String expectedTitle = "Automation Exercise";
        String actualTitle=driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Home Page test PASSED");
        }else {
            System.out.println("Home Page test FAILED");
        }
        Thread.sleep(5000);
        //3. Click 'View Product' for any product on home page
        WebElement viewProductElementi = driver.findElement(By.linkText("View Product"));
        viewProductElementi.click();
        Thread.sleep(4000);

        //4. Verify product detail is opened
        WebElement productInformation = driver.findElement(By.className("product-information"));
        if (productInformation.isDisplayed()){
            System.out.println("Product Details test PASSED");
        }else {
            System.out.println("Product Details test FAILED");}
        Thread.sleep(4000);

        //5. Increase quantity to 4
        WebElement quantityElementi = driver.findElement(By.xpath("//input[@id='quantity']"));
        quantityElementi.clear();
        quantityElementi.sendKeys("4");
        Thread.sleep(3000);

        //6. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@type='button']")).click();

        //7. Click 'View Cart' button
        driver.findElement(By.linkText("View Cart")).click();

        //8. Verify that product is displayed in cart page with exact quantity
        WebElement quantitySon=driver.findElement(By.xpath("//button[@class='disabled']"));
        int siparisMiktari = Integer.parseInt(quantitySon.getText());

        if(siparisMiktari==4){
            System.out.println("Siparis miktari testi PASSED");
        }else {
            System.out.println("Siparis miktari testi FAILED");
        }

        Thread.sleep(5000);
        driver.close();
    }
}
