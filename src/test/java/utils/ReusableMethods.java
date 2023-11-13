package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public  class ReusableMethods {

    static TouchAction touchAction = new TouchAction<>(Driver.getAndroidDriver());

    public static void koordinatTiklama(int x, int y) {
        touchAction.press(PointOption.point(x, y)).release().perform();
        waitHelper.sleep(1);

    }

    public static void scroll(int startX, int startY, int endX, int endY) {
        touchAction
                .press(PointOption.point(startX, startY))  // Başlangıç koordinatları
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))  // 1 saniye bekleyin
                .moveTo(PointOption.point(endX, endY))  // Bitiş koordinatları
                .release()  // Bırak
                .perform();  // İşlemi gerçekleştir
    }

    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver driver = (AndroidDriver)  Driver.getAndroidDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        driver.findElementByXPath("//*[@text='" + elementText + "']").click();

    }


}
