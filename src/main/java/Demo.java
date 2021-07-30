import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Demo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/wp.chen/JAVA/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://i.kedou.com");
        driver.manage().window().maximize();
        driver.switchTo().frame("sso-login");
        driver.findElement(By.name("userName")).sendKeys("cwp_t01");
        driver.findElement(By.name("passwordInp")).sendKeys("cwp123456");
        driver.findElement(By.id("loginButton_YHJ")).click();
        driver.findElement(By.id("js-send-vcode")).click();
        String num=driver.findElement(By.name("number")).getAttribute("value");
        System.out.println(num);
        Thread.sleep(100);
        openNewTab(driver, "http://back.sms.kedou.com/");
        Set <String> windHandels=driver.getWindowHandles();
        List<String> it=new ArrayList<String>(windHandels);
        driver.switchTo().window(it.get(1));
        Thread.sleep(100);
        String url= driver.getCurrentUrl();
        System.out.println(url);
        driver.findElement(By.name("username")).sendKeys("wp.chen@shunwang.com");
        driver.findElement(By.name("password")).sendKeys("cwP911028");
        driver.findElement(By.className("btn-m")).click();
        driver.findElement(By.id("phoneNum")).sendKeys(num);
        driver.findElement(By.id("query")).click();
        String txt=driver.findElement(By.xpath("//*[@id=\"table_list\"]/tbody/tr/td[3]/span")).getAttribute("title");
        System.out.println(txt);
        String num1=txt.substring(10,21);
        System.out.println(num1);


        /*driver.findElement(By.name("activeNo")).sendKeys("123456");
        driver.findElement(By.id("js-submit")).click();*/


    }

    private static void openNewTab(WebDriver driver, String url) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("window.open('"+url+"', '_blank');");
        }
    }
}
