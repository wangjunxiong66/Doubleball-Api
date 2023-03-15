package com.wjx.sportsplatformapi.controller;

import com.alibaba.fastjson.JSON;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/selenium")
public class SeleniumController {

    private static final Logger log = LoggerFactory.getLogger(ExcelOperationController.class) ;

    @RequestMapping("/mail/login")
    public String loginMail(@RequestParam(value = "account") String account1, @RequestParam(value = "password") String password1){
        String account2 = account1 ;
        String password2 = password1 ;
        log.info("传入的邮箱账号是： {}  ，传入的邮箱密码是： {}",account2,password2);

        System.setProperty("webdriver.chrome.driver","/C:/Program Files/Google/Chrome/Application/chromedriver.exe") ;
        WebDriver driver = new ChromeDriver();
        driver.get("http://mail.163.com");
        driver.manage().window().maximize();
        driver.switchTo().frame(0) ;   // 通过index查找
        //  找到账号输入框，此处用id、Xpath方式都不可以，只能用name方式查找
        WebElement accountBox = driver.findElement(By.name("email"));
        accountBox.clear();
        accountBox.sendKeys(account2);
        //  找到密码输入框，此处用id、Xpath方式都不可以，只能用name方式查找
        WebElement passwordBox = driver.findElement(By.name("password")) ;
        passwordBox.clear();
        passwordBox.sendKeys(password2);

        WebElement loginButton = driver.findElement(By.id("dologin")) ;
        log.info("loginbutton:  {}"+loginButton.getText());
        loginButton.click();
        (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d){
                return d.getPageSource().contains("PPT");
            }
        }) ;

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Set<String> allWindowsId = driver.getWindowHandles();
        for (String windowId : allWindowsId){
            if (driver.switchTo().window(windowId).getPageSource().contains("收件箱")){
                driver.switchTo().window(windowId);
                break ;
            }
        }

        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement mailButton = driver.findElement(By.id("_mail_component_5_5")) ;
        mailButton.click();
        log.info("点击邮箱，弹出浮窗");


        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d){
                return  d.getPageSource().contains("退出登录") ;
            }
        }) ;

        if (driver.getPageSource().contains("退出登录")){
            log.info("页面包含  退出登录");
        }

        //   点击“退出登录”时下面方式中只有第一种方式成功了
        WebElement logoutButton = driver.findElement(By.xpath("//*[text()='退出登录']")) ;
        logoutButton.click();

        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver d){
                return  d.getPageSource().contains("您已成功退出邮箱");
            }
        }) ;

        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement loginAgainButton = driver.findElement(By.linkText("重新登录")) ;
        loginAgainButton.click();
        (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver d){
                return  d.getPageSource().contains("注册新帐号");
            }
        }) ;
        driver.close();
        driver.quit();

        HashMap<String,Object> res = new HashMap<>();
        res.put("flag","ok");
        String res_json = JSON.toJSONString(res);
        return res_json;
    }

}
