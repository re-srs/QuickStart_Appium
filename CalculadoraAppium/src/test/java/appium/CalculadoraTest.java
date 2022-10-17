package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculadoraTest {

    @Test
    public  void deveSomarDoisValores() throws MalformedURLException {

        DesiredCapabilities configuracoes = new DesiredCapabilities();
        configuracoes.setCapability("platformName","Android");
        configuracoes.setCapability("deviceName","emulator-5554");
        configuracoes.setCapability("automationName","uiautomator2");
        configuracoes.setCapability("appPackage","com.android.calculator2");
        configuracoes.setCapability("appActivity","com.android.calculator2.Calculator");

        URL urlConexao = new URL("http://127.0.0.1:4723/wd/hub");
        AppiumDriver driver = new AppiumDriver(urlConexao, configuracoes);

        MobileElement el1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
        Assert.assertEquals("4", el4.getText());

    }
}
