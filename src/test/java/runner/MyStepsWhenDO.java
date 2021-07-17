package runner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MyStepsWhenDO {
    private AppiumDriver driver;
    @Given("tengo acceso a WhenDo")
    public void tengoAccesoAWhenDo() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();

        capabilities.setCapability("deviceName","G3223");
        capabilities.setCapability("platformVersion","8");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity",".ui.HomeActivity");
        capabilities.setCapability("platformName","Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @When("clic al boton {string}")
    public void clicAlBoton(String nameButton) throws InterruptedException {

        if (nameButton.equals("Agregar")) {
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();

        } else {
            //click Save button
            driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
        }
        Thread.sleep(5000);

    }

    @And("llenar la caja de texto Titulo con {}")
    public void llenarLaCajaDeTextoTituloCon(String Titulo) throws InterruptedException {
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(Titulo);
        Thread.sleep(2000);
    }

    @And("llena la caja de texto Notas con {}")
    public void llenaLaCajaDeTextoNotasCon(String Notas) {
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(Notas);
    }


    @Then("el item {} deberia ser creado")
    public void elItemDeberiaSerCreado(String ExpectedItem) throws InterruptedException {

        WebDriverWait explicitWait= new WebDriverWait(driver,10);

        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='"+ExpectedItem+"']")));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='"+ExpectedItem+"']")));
        //verificar la nota
        Assertions.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='"+ExpectedItem+"']")).isDisplayed());

        Thread.sleep(5000);
        driver.quit();
    }
}
