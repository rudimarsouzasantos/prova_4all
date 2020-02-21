package utilit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MapElement {
	
    public MapElement() { }
    
    public void changeForFrame(WebDriver driver, String idFrame)
    {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement iframe = driver.findElement(By.id(idFrame));
        driver.switchTo().frame(iframe);
    }
    
    public WebElement mapElement(WebDriver driver, String element, String tpElement)
    {
        if (tpElement.equals("id"))
        {
            return driver.findElement(By.id(element));
        }
        if (tpElement.equals("xpath"))
        {
            return driver.findElement(By.xpath(element));
        }
        return null;
    }

}
