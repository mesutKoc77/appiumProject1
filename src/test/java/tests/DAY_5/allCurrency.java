package tests.DAY_5;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrency;
import utils.Driver;
import utils.ReusableMethods;
import utils.waitHelper;

public class allCurrency {

    AllCurrency allCurrency = new AllCurrency();

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();

    /*
    yeni bir app testinde oncelikle onu telefonumuza yuklemeli
    Bunun icin de appYukleme class ini calistirarak ilgili App i telefonumuza yukkeriz.
     */

    @Test
    public void testAllCurrency() {

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
        allCurrency.numberZero.click();
        allCurrency.numberZero.click();
        allCurrency.numberZero.click();

        //1.52


    }
}