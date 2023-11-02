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
import org.testng.annotations.Test;
import pages.KiwiPage;
import utils.Driver;
import utils.waitHelper;

import java.util.List;

public class KiwiCom {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    WebDriverWait wait= new WebDriverWait(driver, 10); //bunu reusable method tarafina atabiliri misin.
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
        kiwiPage.ayniNoktayaTiklama(4,531,1692);

        wait.until(ExpectedConditions.elementToBeClickable(kiwiPage.Return)).click();
        kiwiPage.koordinatTiklama(1016,1452);
        //default kalkisi siler
        kiwiPage.koordinatTiklama(363,775);
        kiwiPage.koordinatTiklama(1019,135);

        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("Kayseri");
            wait.until(ExpectedConditions.elementToBeClickable(kiwiPage.kayseri)).click();
        } else {
            kiwiPage.departureBox.sendKeys("Atina");
        }

        wait.until(ExpectedConditions.elementToBeClickable(kiwiPage.choose)).click();
        kiwiPage.koordinatTiklama(353,920);

        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("Singapur");
            wait.until(ExpectedConditions.elementToBeClickable(kiwiPage.singapore)).click();
        } else {
            kiwiPage.departureBox.sendKeys("Atina");
        }

        wait.until(ExpectedConditions.elementToBeClickable(kiwiPage.choose)).click();
        kiwiPage.koordinatTiklama(538,1346);



        waitHelper.sleep(2);
        Driver.quitAppiumDriver();


    }

}
