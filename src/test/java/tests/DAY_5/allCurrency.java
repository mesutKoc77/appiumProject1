package tests.DAY_5;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrency;
import utils.Driver;
import utils.ReusableMethods;
import utils.waitHelper;

import java.io.File;
import java.io.IOException;

public class allCurrency {

    AllCurrency allCurrency = new AllCurrency();

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();

    /*
    yeni bir app testinde oncelikle onu telefonumuza yuklemeli
    Bunun icin de appYukleme class ini calistirarak ilgili App i telefonumuza yukkeriz.
     */

    @Test
    public void testAllCurrency() throws IOException {

        System.out.println(driver.getDeviceTime());

        Assert.assertTrue(driver.isAppInstalled(Driver.APP_PACKAGE));

        WebElement allCurrencyText = waitHelper.waitForVisible(allCurrency.allCurrencyText, 10);

        Assert.assertTrue(allCurrencyText.isDisplayed());

        /*
        kullanici para birimi olarak zouity  ve tl secer
        screenshot alinir
        tl karsilgi kayit edilir

         */
        //methidlari static yapayim ki diger class lardan cagirabileyim. Ama class icindeki bazi variable vb cagirmak ve oradaki objeleri kullanmak istersek
        //tabii ki o class dan bir obje olusturmak gerekiyor...

        //ayrica ornegin ReusableMethods icersinde bir variable a ulasmak istiyrum. Bu durumda o variable i public yapmam gerekoiyr.

        ReusableMethods.koordinatTiklama(497,345);

        ReusableMethods.scrollWithUiScrollable("Polish Zloty");

        ReusableMethods.koordinatTiklama(500,495);

        ReusableMethods.scrollWithUiScrollable("TRY");

        allCurrency.numberOne.click();

        for (int i = 0; i < 3; i++) {
            allCurrency.numberZero.click();
        }
        //ekranin screenahot i alinir

        /*
        Manuel screenshot alma
        File screenshotAs = driver.getScreenshotAs(OutputType.FILE); //ekran goruntusunu cekiyor. ve bir file olarak cekiyor.
        FileUtils.copyFile(screenshotAs,new File("tlotyToll.jpg")); //cekilen foto yu bir dosyaya kayit ediyor.
         */

        ReusableMethods.getScreenshot("zoolotyTl");

        String text = allCurrency.resultChange.getText();
        driver.sendSMS("88888888",text);



    }
}