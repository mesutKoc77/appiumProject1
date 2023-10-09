import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ArabamComTest {

    AndroidDriver<AndroidElement> driver;
    String bundleIdArabam = "com.dogan.arabam";

    WebDriverWait wait;


    @BeforeTest
    public void arabamTestiSetup() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        String testeAnaSayfadanBasla = "com.dogan.arabam.presentation.feature.home.HomeActivity";
        //simdi diger dersten farkli olarak asagidaki iki adimi ekledik ve aktivite ettik.
        capabilities.setCapability("appPackage", bundleIdArabam);//ben  burada arabam App ile ilgili test yapmak istedgiimden bunu ekledim. ve bu uygulamayi ac dedim.
        capabilities.setCapability("appActivity", testeAnaSayfadanBasla);//bu ise teste konu uygulamanin hangi sayfasindan baslamak istedgimizi belirttgmz yer.

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    @Test
    public void birinciTestim() throws InterruptedException {


        //arabam kac para ya tiklar

        //once uygulamanin yuklendigi ve acildigi dogrulamsini yapmak gerekiyor.
        Assert.assertTrue(driver.isAppInstalled(bundleIdArabam));
        AndroidElement logo = driver.findElementById("com.dogan.arabam:id/ivArabamLogo");
        Assert.assertTrue(logo.isDisplayed());

        //kac paraya tiklar

        AndroidElement kacpara = driver.findElementByXPath("//*[@text='Arabam kaç para?']");
        kacpara.click();

        //fiyat merak ediyor

        //not locate alirken bastaki @ lere dikkat et.

        AndroidElement merak = driver.findElementByXPath("(//*[@resource-id='com.dogan.arabam:id/tvTitle'])[4]");
        merak.click();

        //login ol

        driver.findElementById("com.dogan.arabam:id/et_email").sendKeys("arabam.com@byom.de");
        driver.findElementById("com.dogan.arabam:id/et_password").sendKeys("Mesutk1,");
        Thread.sleep(2000);
        driver.findElementById("com.dogan.arabam:id/btn_login").click();
        wait = new WebDriverWait(driver, 10);

        AndroidElement merak2 = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Aracımın fiyatını merak ediyorum']")));

        merak2.click();


        //vw markasini sec











        //yil sec
        //model sec
        //govde tipi sec


    }


}
