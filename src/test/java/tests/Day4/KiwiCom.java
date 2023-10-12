package tests.Day4;

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

        for (int i = 0; i < 3; i++) {
            touchAction.press(PointOption.point(531,1692)).release().perform();
            waitHelper.sleep(1);

        }












        //






        waitHelper.sleep(2);
        Driver.quitAppiumDriver();


    }

}
