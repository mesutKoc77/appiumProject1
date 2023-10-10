package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class _Calculator_Test {


    AndroidDriver<AndroidElement> driver; // Android cihazlarin testi soz konusu olursa kullanilir.


    //AppiumDriver<AndroidElement> driver2; //hem Android hem de Ios cihazlarin testinde kullanilabilir. Android icin bu driver kullanilaabilir.
    // AppiumDriver<MobileElement> driver3; //ios icin kullanilir. Fakat Andorid icin de kullanilabilir.

    @Test
    public void test1() throws MalformedURLException, InterruptedException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); //"Android 6" nin altinda bir surum soz konusu ise
        //UiAutomator kullanilir.
        //capabilities.setCapability(MobileCapabilityType.APP,"/Users/mesut/IdeaProjects/Appium_T_113/Apps/Calculator_8.4.1 (520193683)_Apkpure.apk"); //bu path ini verdigin uygulmayi yukler. yuklu ise zaten,
        //o zaman acacaktir.

        //app capabilitytype bir uygulmyi yuklee /*
        // mek istedigimizde indirdigimiz apk dosyasinin path uzantisini  vererek
        // o uygulamayi yuklemek icin kullandigimiz desiredCapability./

        //biz asagida driver i kullanrak appActivate fonksyionu ile teste konu uyguklamayi actik ama driver ile actik.
        //Simdi ise biz setCapability fonksiynunu kulölanarak desiredCapability paketini kullanarak bunu saglayaacgiz. Bunu yazdim ve en asagidakini de yoruma aliyorum.
        String calculateInBundleid = "com.google.android.calculator";
       // capabilities.setCapability("appPackage",calculateInBundleid); //aktivite icin 2 deger yazdik. Bu birincisi
        // capabilities.setCapability("appActivity", "com.android.calculator2.Calculator"); //aktivite icin 2 deger yazdik. Bu da ikincisi //bu degeri nerden bulacagin da arabam.com class dersinde
        //aciklandi.
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
//inspector ile java farkli farkli baglantidingda
        //emulator ile olan baglantilar kopar.
        //dolayisiyla her biri icin ayri ayri baglanti yapilmali
        //yani locate icin ayrica inspector ile emulator
        //baglantisi kurulmali
        //testi de yapmak icin de java ile emulator baglantisini
                    //yapman gerekiyor.



        driver.activateApp(calculateInBundleid);//burada ise uygulamayi active ettim ve onun yerine yukarida bunu ikame ettim. capabilities.setCapability("appPackage",calculateInBundleid);
        Assert.assertTrue(driver.isAppInstalled(calculateInBundleid));

        ////

        AndroidElement acButonu=driver.findElementByAccessibilityId("clear");
        Assert.assertTrue(acButonu.isDisplayed());

        //simdi de bir test yapip tiklama slevlerini yerine getorecegiz ve test edevcegz

        driver.findElementByAccessibilityId("8").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("2").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("equals").click();

        String esittirLocatei = "com.google.android.calculator:id/result_final";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(esittirLocatei)));
        String resultText=driver.findElementById(esittirLocatei).getText();
        Assert.assertEquals(Integer.parseInt(resultText),1600);



    }


}
