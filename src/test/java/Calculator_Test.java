import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Calculator_Test {


    AndroidDriver<AndroidElement> driver; // Android cihazlarin testi soz konusu olursa kullanilir.

    //AppiumDriver<AndroidElement> driver2; //hem Android hem de Ios cihazlarin testinde kullanilabilir. Android icin bu driver kullanilaabilir.
    // AppiumDriver<MobileElement> driver3; //ios icin kullanilir. Fakat Andorid icin de kullanilabilir.

    @Test
    public void test1() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();
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
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//inspector ile java farkli farkli baglantidingda
        //emulator ile olan baglantilar kopar.
        //dolayisiyla her biri icin ayri ayri baglanti yapilmali
        //yani locate icin ayrica inspector ile emulator
        //baglantisi kurulmali
        //testi de yapmak icin de java ile emulator baglantisini
        //yapman gerekiyor.

        /*
        uygulamayi acar
        uygulamanin yuklendigini dogrular
        uygulamnin acildgini dogrular
        dort islem yapar ve sonuclari dogrular
        ac butonuna basarak ekrani temizler

         */

        String calculateinBundleid="com.google.android.calculator";

        driver.activateApp(calculateinBundleid);//burada ise uygulamayi actKov
        Assert.assertTrue( driver.isAppInstalled(calculateinBundleid));




    }












}
