import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class automationExcercise_01 {

    public static void main(String[] args) throws InterruptedException {

        //1. Launch browser

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Navigate to url 'http://automationexercise.com'

        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully

        String expectedUrl = "http://automationexercise.com";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)) {
            System.out.println("test url is Passed");
        } else {
            System.out.println("test url is Failed");
            System.out.println("Actual URL"+ actualUrl);
        }

        //4. Click on 'Signup / Login' button

        driver.findElement(By.xpath("//*[@*='/login']")).click();

        //5. Verify 'New User Signup!' is visible

        WebElement SignUp = driver.findElement(By.xpath("//h2[text()=\"New User Signup!\"]"));
        SignUp.isDisplayed();
        /*
        if (SignUp.isDisplayed()) {
            System.out.println("test signUp display PASSED");
        } else {
            System.out.println("test signUp display  FAILED");
        }
        */

        //6. Enter name and email address

        WebElement SignUpName = driver.findElement(By.xpath("//*[@*=\"name\"]"));
        // driver'in isim kutusunu bulmasi icin html kodlarini yaziyoruz
        Actions actions = new Actions(driver); // driver'a klavye uzerinden islem yaptirmak icin actions olusturuyoruz
        Faker faker = new Faker(); // fake hesaplar olusturmak icin faker class'dan obje olusturuyoruz

        String email =faker.internet().emailAddress(); // email adresini ikinci defa istedigi icin,
        // buraya bi tane olusturup string olarak kaydediyoruz

        actions.click(SignUpName) // oncelikle isim kutusuna click yapiyoruz
                .sendKeys(faker.name().firstName()) // fake bir isim olusturmasini soyluyoruz
                .sendKeys(Keys.TAB) // ilk isim kutusuna isim yazdiktan sonra diger kutulara gecmek icin tab tusuna basiyoruz
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .perform();



        //7. Click 'Signup' button

        driver.findElement(By.xpath("(//*[@*=\"btn btn-default\"])[2]")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

        WebElement enterAccountText = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        enterAccountText.isDisplayed();
        Thread.sleep(3000);

        //9. Fill details: Title, Name, Email, Password, Date of birth

        driver.findElement(By.xpath("(//*[@class='top'])[2]")).click();
        driver.findElement(By.xpath("(//*[@*='name'])[2]")).submit();




        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        //14. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        driver.quit();


    }
}
