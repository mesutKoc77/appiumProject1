package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.waitHelper;

import java.time.Duration;

public class KiwiPage {

    TouchAction touchAction = new TouchAction<>(Driver.getAndroidDriver());



    public KiwiPage() {
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(), this);
    }
    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement misafir;

    @FindBy(xpath = "//*[@text='Return']")
    public WebElement Return;

    @FindBy(xpath = "//*[@text='One Way']")
    public WebElement OneWay;

    @FindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement departureBox;

    @FindBy(xpath = "//*[@text='Istanbul, Turkey']")
    public WebElement kayseri;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement choose;

    @FindBy(xpath = "//*[@text='Singapore, Singapore']")
    public WebElement singapore;

    @FindBy(id="com.skypicker.main:id/saveButton")
    public WebElement saveButton;

    @FindBy(xpath = "(//*[@text=\"Search\"])[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@text=\"Best\"]")
    public WebElement best;

    @FindBy(xpath = "//*[@text=\"Cheapest\"]")
    public WebElement cheapButton;

    @FindBy(xpath = "//*[@text=\"Stops\"]")
    public WebElement stopsButton;

    @FindBy(xpath = "//*[@text=\"Direct\"]")
    public WebElement direktButton;

    @FindBy(xpath ="(//*[@class=\"android.widget.TextView\"])[13]")
    public WebElement priceElemet;








    public void ayniNoktayaTiklama(int kacKereTikla, int xKoor, int yKoor){

        for (int i = 0; i < kacKereTikla ; i++) {

            touchAction.press(PointOption.point(xKoor,yKoor)).release().perform();
            waitHelper.sleep(1);
        }

    }

    public void koordinatTiklama(int x, int y) {
        touchAction.press(PointOption.point(x,y)).release().perform();
        waitHelper.sleep(1);

    }
    public void scroll(int startX, int startY, int endX, int endY) {
        touchAction
                .press(PointOption.point(startX, startY))  // Başlangıç koordinatları
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))  // 1 saniye bekleyin
                .moveTo(PointOption.point(endX, endY))  // Bitiş koordinatları
                .release()  // Bırak
                .perform();  // İşlemi gerçekleştir
    }





}
