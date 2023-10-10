package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppYukleme {

    AndroidDriver<AndroidElement> driver;


    @Test
    public void test1() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); //"Android 6" nin altinda bir surum soz konusu ise
        //UiAutomator kullanilir.
        //bir sonraki satir herhangi bir uygulamayi yuklemek icin kullanilir.
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/mesut/IdeaProjects/Appium_T_113/Apps/Apk Bilgisi_2.3.4_apkcombo.com.apk");
        //app capabilitytype bir uygulmyi yuklee /*
        // mek istedigimizde indirdigimiz apk dosyasinin path uzantisini  vererek
        // o uygulamayi yuklemek icin kullandigimiz desiredCapability./
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



        /*
        Kullanici gerekli ayarlamalari yapar.
        kullanici uygulamanin basariyla yuklendigini test eder.

         */

}
}

