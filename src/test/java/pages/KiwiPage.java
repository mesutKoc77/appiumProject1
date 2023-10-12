package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class KiwiPage {

    public KiwiPage() {
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(), this);
    }
    @FindBy(xpath = "//*[@text='Konuk olarak devam et']")
    public WebElement misafir;



}
