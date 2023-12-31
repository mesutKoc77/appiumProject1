package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;


public class AllCurrency {

    public AllCurrency() {
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(), this);
    }
    @FindBy(xpath = "//*[@text='PARA BIRIMI DÖNÜŞTÜRÜCÜ']") //telefon diline gore degisiyor
    public WebElement allCurrencyText;

    @FindBy (id = "com.smartwho.SmartAllCurrencyConverter:id/b1")
    public WebElement numberOne;

    @FindBy (id = "com.smartwho.SmartAllCurrencyConverter:id/b0")
    public WebElement numberZero;


    @FindBy (id = "com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB")
    public WebElement resultChange;




}
