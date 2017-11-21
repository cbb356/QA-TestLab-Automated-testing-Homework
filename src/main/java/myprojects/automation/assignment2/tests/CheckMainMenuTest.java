package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckMainMenuTest extends BaseScript{

    public static void main(String[] args) throws InterruptedException {
        //Launch browser
        WebDriver driver = getConfiguredDriver();

        //Login to Admin panel
        driver.get(Properties.getBaseAdminUrl());
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).click();

        //Check MenuItems number
        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='menu']/li[contains(@class, 'maintab')]/a"));

        //Cycle verifying all MenuItems
        for (int i = 1; i <= menuItems.size(); i++) {
            driver.findElement(By.xpath("(//ul[contains(@class,'menu')]/li[contains(@class,'link-levelone') or contains(@class,'maintab')]/a)[" + i + "]")).click();
            String pageTitle = driver.getTitle();
            System.out.println("The page title is: " + pageTitle);
            driver.navigate().refresh();
            if (pageTitle.equals(driver.getTitle())) {
                System.out.println("The page " + pageTitle + " is not changed after reloading");
            }
            else {
                System.out.println("The page " + pageTitle + " is changed after reloading");
            }
        }

        //Quit
        driver.quit();
    }
}
