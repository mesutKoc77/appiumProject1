package tests.Day4;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
//import org.testng.annotations.Test;
import pages.KiwiPage;
import utils.Driver;
import utils.waitHelper;
//import org.junit.jupiter.api.Test;
//import org.junit.Test; // JUnit 4 için
import org.testng.annotations.Test;

import java.util.List;

public class KiwiCom {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10); //bunu reusable method tarafina atabiliri misin.
    //a obje from KiwiPage
    KiwiPage kiwiPage = new KiwiPage();
    TouchAction touchAction = new TouchAction<>(driver);

    @Test
    public void testKiwiCom() {
        System.out.println(driver.getDeviceTime());
        //uygulamanin basariyla yuklendigini test eder.
        Assert.assertTrue(driver.isAppInstalled(Driver.APP_PACKAGE));
        ///verifies that the application has been opened successfully.
        // AndroidElement misafir = driver.findElementByXPath("//*[@text='Konuk olarak devam et']"); artik obje olustrurduk
        Assert.assertTrue(kiwiPage.misafir.isDisplayed());
        //konuk olarak devam et e tiklar
        wait.until(ExpectedConditions.elementToBeClickable(kiwiPage.misafir)).click(); //reusable methods a atip ordan cagirirlabilirdi.
        //adimlarin hepsinde yesil butona tiklar.

        //asagikai sekilde de ilgili noktanin koordinatlari esas ainarak da tiklama islemi yapilabilir-
        kiwiPage.ayniNoktayaTiklama(4, 511, 1696);

        wait.until(ExpectedConditions.elementToBeClickable(kiwiPage.Return)).click();
        kiwiPage.koordinatTiklama(1016, 1452);
        //default kalkisi siler
        kiwiPage.koordinatTiklama(363, 775);
        kiwiPage.koordinatTiklama(1019, 135);

        if (driver.isKeyboardShown()) {
            driver.getKeyboard().pressKey("istanbul");
            wait.until(ExpectedConditions.elementToBeClickable(kiwiPage.kayseri)).click();
        } else {
            kiwiPage.departureBox.sendKeys("Atina");
        }

        wait.until(ExpectedConditions.elementToBeClickable(kiwiPage.choose)).click();
        kiwiPage.koordinatTiklama(353, 920);

        if (driver.isKeyboardShown()) {
            driver.getKeyboard().pressKey("Singapur");
            wait.until(ExpectedConditions.elementToBeClickable(kiwiPage.singapore)).click();
        } else {
            kiwiPage.departureBox.sendKeys("Atina");
        }

        wait.until(ExpectedConditions.elementToBeClickable(kiwiPage.choose)).click();
        kiwiPage.koordinatTiklama(538, 1346);

        kiwiPage.koordinatTiklama(571, 1042);

        kiwiPage.scroll(511, 1329, 541, 234);

        kiwiPage.koordinatTiklama(551, 772);

        kiwiPage.saveButton.click();

        waitHelper.waitForClickablility(kiwiPage.searchButton,10).click();
        waitHelper.waitForClickablility(kiwiPage.best,10).click();
        waitHelper.waitForClickablility(kiwiPage.cheapButton,10).click();

        waitHelper.waitForClickablility(kiwiPage.stopsButton,10).click();
        waitHelper.waitForClickablility(kiwiPage.direktButton,10).click();

        String text = waitHelper.waitForVisible(kiwiPage.priceElemet, 10).getText();
        String number="83278437848";
        Driver.getAndroidDriver().sendSMS(number, text);




        /*
           //ilk fiyati al
           bu fiyati alsin ve send mesaj yapsin

         */


        waitHelper.sleep(2);
        Driver.quitAppiumDriver();


    }

}
