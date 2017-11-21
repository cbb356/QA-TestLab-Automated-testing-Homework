package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        //Launch browser
        WebDriver driver = getConfiguredDriver();

        //Login to Admin Panel
        driver.get(Properties.getBaseAdminUrl());
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).click();

        //Logout
        driver.findElement(By.className("employee_avatar_small")).click();
        driver.findElement(By.id("header_logout")).click();

        //Quit
        driver.quit();
    }
}
