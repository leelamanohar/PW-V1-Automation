package com.rp.automation.framework;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Propertyware Automation Team
 */
public class ScreenShotListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr) {

        if (WebDriverBase.getDriver() != null) {
            Reporter.setCurrentTestResult(tr);
            File screenShot = new File("ScreenShots" + File.separator + System.currentTimeMillis() + ".png");
            if (!screenShot.exists()) {
                new File(screenShot.getParent()).mkdirs();
                try {
                    screenShot.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {

                WebDriver driver = new Augmenter().augment(WebDriverBase.getDriver());
                new FileOutputStream(screenShot).write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Reporter.log("<br> <img src=\""
                    + new File(screenShot.toString()).getAbsoluteFile()
                    + "\" alt=\"Screen shot not available\" height=\"700\" width=\"800\"> <br>");
        }
    }
}
