import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        SignUpName.sendKeys("gulnur");
        WebElement SignUpEmail= driver.findElement(By.xpath("(//*[@*=\"email\"])[2]"));
        SignUpEmail.sendKeys("taskin.gulnur@gmail.com");

        //7. Click 'Signup' button

        driver.findElement(By.xpath("(//*[@*=\"btn btn-default\"])[2]")).click();
        Thread.sleep(3000);

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        //9. Fill details: Title, Name, Email, Password, Date of birth
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
        /*
        git init
git add .
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/GulnurTaskin/Automation-Excercise.git
git push -u origin main
         */

    }
}
