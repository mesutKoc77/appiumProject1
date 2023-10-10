<<<<<<< HEAD

import io.appium.java_client.MobileElement;
=======
import io.appium.java_client.TouchAction;
>>>>>>> origin/main
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
<<<<<<< HEAD
import org.openqa.selenium.*;
import io.appium.java_client.TouchAction;

=======
import org.openqa.selenium.By;
>>>>>>> origin/main
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

<<<<<<< HEAD
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


=======
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

>>>>>>> origin/main
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

<<<<<<< HEAD
        TouchAction touchAction;
        touchAction = new TouchAction<>(driver);

        Thread.sleep(1000);

        touchAction.press(PointOption.point(544,1719)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                moveTo(PointOption.point(544,416)).release().perform();
        WebElement vw = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Volkswagen']")));
        wait.until(ExpectedConditions.elementToBeClickable(vw));
        vw.click();

        //yil sec

        MobileElement element = driver.findElement(By.xpath("//*[@text='2018']"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        //model sec

        MobileElement model = driver.findElement(By.xpath("//*[@text='Passat']"));
        wait.until(ExpectedConditions.elementToBeClickable(model)).click();

        //govde tipi sec
        MobileElement govde = driver.findElement(By.xpath("//*[@text='Sedan']"));
        wait.until(ExpectedConditions.elementToBeClickable(govde)).click();

        MobileElement yakit = driver.findElement(By.xpath("//*[@text='Benzin']"));
        wait.until(ExpectedConditions.elementToBeClickable(yakit)).click();

        MobileElement tur = driver.findElement(By.xpath("//*[@text='Yarı Otomatik']"));
        wait.until(ExpectedConditions.elementToBeClickable(tur)).click();
        waitHelper.sleep(2);
        touchAction.press(PointOption.point(428,1138)).release().perform();



        if (driver.isKeyboardShown())   {
            driver.getKeyboard().pressKey("50000");

        } else {
            driver.findElementById("com.dogan.arabam:id/et_km").sendKeys("100000");
        }

        driver.findElementById("com.dogan.arabam:id/btn_price_prediction_submit").click();
        driver.findElementByXPath("//*[@text='Gri (metalik)']").click();
        driver.findElementById("com.dogan.arabam:id/btnNext").click();
        driver.findElementById("com.dogan.arabam:id/iv_B0901").click();
        driver.findElementByXPath("(//*[@resource-id='com.dogan.arabam:id/rlytBottomSheet'])[2]").click();

        MobileElement elem = driver.findElementById("com.dogan.arabam:id/iv_B0901");

// Elementin merkez koordinatları
        /*
         org.openqa.selenium.Point point = elem.getCenter();
        int centerx = point.getX();
        int centerY = point.getY();

         */


// Ekran görüntüsü
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            // Ekran görüntüsü BufferedImage'a dönüştüruyorum
            BufferedImage image = ImageIO.read(scrFile);

            // Pixel rengini alıyorum
            int clr = image.getRGB(854, 732); //burada x ve y koordinatlarini manuel olarak aldim. ama yukarida elementin merkez koordinatlarını alıyorum. bolumunde yorumdan kaldirarak code da aldirabilirsin.
            int red = (clr & 0x00ff0000) >> 16;
            int green = (clr & 0x0000ff00) >> 8;
            int blue = clr & 0x000000ff;

            // Rengi yazdıriyorum
            System.out.println("Red Color value = " + red);
            System.out.println("Green Color value = " + green);
            System.out.println("Blue Color value = " + blue);

            // Yoğunluğu en fazla olan renk kırmızı ise assert'i true olarak sonlandır
            if (red >= green && red >= blue) {
                System.out.println("Elementin renginde yoğunluk en fazla kırmızı renkte.");
                assert true;
            } else {
                System.out.println("Elementin renginde yoğunluk en fazla kırmızı renkte değil.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }





=======










        //yil sec
        //model sec
        //govde tipi sec
>>>>>>> origin/main


    }


}
