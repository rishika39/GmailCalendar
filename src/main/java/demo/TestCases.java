package demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.its.ITSPublicEncryptionKey.symmAlgorithm;
import org.checkerframework.checker.units.qual.m;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Task;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);
       // WebDriverWait wait = new WebDriverWait(driver, 10);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // Set browser to maximize and wait
       // driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

   public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://calendar.google.com/");
        String title = driver.getCurrentUrl();
        if (title.toLowerCase().contains("calendar")) {
            System.out.println("The URL homepage contains calendar.");
        } else {
            System.out.println("The URL does not contain calendar.");
        }
        System.out.println("end Test case: testCase01");
    }

 public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        driver.get("https://calendar.google.com/");
        Thread.sleep(2000);
        //dropdown
        driver.findElement(By.xpath("//button[@class=\"VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-INsAgc VfPpkd-LgbsSe-OWXEXe-Bz112c-UbuQg VfPpkd-LgbsSe-OWXEXe-dgl2Hf Rj2Mlf OLiIxf PDpWxe LQeN7 j9Fkxf I2n60c\"]")).click();
        Thread.sleep(3000);
        //month view 
        WebElement month= driver.findElement(By.xpath("//*[@id='ucc-1']/ul/li[3]/span[3]"));
        month.click();
        Thread.sleep(3000);
        WebElement mnthtxt=driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[2]/div[3]/div/div/div/div[5]/div/div[1]/div[1]/div/button/span"));
        if(mnthtxt.getText().equals("Month")){
            System.out.println("its month view");
        }
        else{
            System.out.println("its not a month view");
        }
//JavascriptExecutor js = (JavascriptExecutor) driver;
//js.executeScript("arguments[0].click();", month);
Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"YPCqFe\"]/div/div/div/div[2]/div[5]/div[1]/div[4]")).click();
        Thread.sleep(3000);
    
        driver.findElement(By.xpath("//*[@id='tabTask']/div[2]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder=\"Add title and time\"]")).sendKeys("Crio INTV Task Automation");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//textarea[@placeholder=\"Add description\"]")).sendKeys("Crio INTV Calendar Task Automation");
        driver.findElement(By.xpath("//button[@class=\"VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 pEVtpe\"]")).click();

        WebElement opentask=driver.findElement(By.xpath("//*[@id=\"YPCqFe\"]/div/div/div/div[2]/div[5]/div[3]/div/div[4]/div/div"));

        //WebElement successMessage = driver.findElement(By.xpath("//div[@Text()='Task created']")); // Use correct locator
        if (opentask.isDisplayed()) {
            System.out.println("Task was created successfully.");
        } else {
            System.out.println("Failed to create the task.");
        }
        System.out.println("end Test case: testCase02");
 }

 public  void testCase03() throws InterruptedException{
    System.out.println("Start Test case: testCase03");
    driver.get("https://calendar.google.com/");
Thread.sleep(3000);
    WebElement opentask=driver.findElement(By.xpath("//*[@id=\"YPCqFe\"]/div/div/div/div[2]/div[5]/div[3]/div/div[4]/div/div"));
    opentask.click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/div[1]/div/div[2]/span/div/div[1]/div/div/div[2]/div[1]/span/button")).click();
    Thread.sleep(2000);

    driver.findElement(By.xpath("//textarea[@placeholder=\"Add description\"]")).sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
    Thread.sleep(2000);
    //save
    driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/div/div/div[2]/span/div/div[8]/div/button")).click();
Thread.sleep(2000);
    opentask.click();
    Thread.sleep(2000);
    WebElement des=driver.findElement(By.xpath("//*[@id='xDetDlgDesc']"));
    String Actual="Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application";
    if(des.getText()==Actual){
        System.out.println("Description is updated");
    }
    else{
        System.out.println("Description is not updated");
    }

    System.out.println("end Test case: testCase03");
    
}
public  void testCase04() throws InterruptedException{
    System.out.println("Start Test case: testCase04");
    driver.get("https://calendar.google.com/");
    Thread.sleep(3000);
    WebElement opentask=driver.findElement(By.xpath("//*[@id=\"YPCqFe\"]/div/div/div/div[2]/div[5]/div[3]/div/div[4]/div/div"));
    opentask.click();
    Thread.sleep(2000);
    String act="Crio INTV Task Automation";
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement txt=driver.findElement(By.xpath("//*[@id=\"rAECCd\"]"));
    Thread.sleep(2000);
    if(txt.getText().equals(act)){
    driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/div/div/div[2]/span/div/div[1]/div/div/div[2]/div[2]/span/button")).click();
    //Thread.sleep(2000);   
     WebElement al = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"VYTiVb\"]")));
        if(al.getText().contains("Task deleted")){
            System.out.println("Task has been successfully deleted.");
            } else {
                System.out.println("Task still exists.");
        }

    List<WebElement> tasks = driver.findElements(By.xpath("//span[text() = 'Crio INTV Task Automation']"));
            if (tasks.isEmpty()) {
                System.out.println("Task has been successfully deleted.");
            } else {
                System.out.println("Task still exists.");
            }
}
else{
    System.out.println("Task not present");
}
    System.out.println("end Test case: testCase04");
}
}
