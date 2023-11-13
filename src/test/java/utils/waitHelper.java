package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waitHelper {



    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000); // Saniyeyi milisaniyeye çevirerek bekler
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Kesinti durumunda hatayı işler
        }
    }

    public static WebElement waitForClickablility (WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getAndroidDriver(), Duration.ofSeconds(timeout).getSeconds());
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static  WebElement waitForVisible (WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getAndroidDriver(), Duration.ofSeconds(timeout).getSeconds());
        return wait.until(ExpectedConditions.visibilityOf(element));
    }





}
