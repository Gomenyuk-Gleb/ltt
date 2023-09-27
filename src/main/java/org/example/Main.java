package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Main {
    public static WebDriver init(WebDriver wd) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--window-size=1920,1080");
//        options.addArguments("--window-position=0,0");
//        options.addArguments("--host-resolver-rules=MAP js.intercomcdn.com 127.0.0.1");
        String userAgentParam = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36";
        options.addArguments("user-agent=" + userAgentParam);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--chrome-frame");

        wd = new ChromeDriver(options);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wd.manage().timeouts().scriptTimeout(Duration.ofSeconds(90));
        return wd;
    }


}