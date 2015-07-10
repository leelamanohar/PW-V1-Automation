package com.rp.automation.framework;

import com.google.common.base.Predicate;
import com.rp.pw.pages.LoginPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Created by Propertyware Automation Team
 */
public class WebDriverHelper {
    WebDriver driver;

    public WebDriverHelper(WebDriver driver) {    	
        this.driver = driver;
    }
  

    public WebElement waitForElementToBeDisplayed(final WebElement element,
                                                  int timeOutPeriod) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.SECONDS);

        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {
                    if (element.isDisplayed())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {

                    return null;
                }
            }

        });
    }

    public WebElement waitForElementToBeDisplayed(final By by, int timeOutPeriod) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {
                    WebElement element = driver.findElement(by);
                    if (element.isDisplayed())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }
    

    
    public WebDriver WAIT_FOR_FRAME_TO_BE_DISPLAYED(WebDriver driver, int timeOutPeriod,final String svalue) {
    	WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(svalue));
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
      
        return webDriverWait.until(new ExpectedCondition<WebDriver>() {
        	
        	 public  WebDriver apply(WebDriver driver) {
        		 //String sFrame=svalue;
                try {
                    //WebDriver newdriver = driver;
                        return driver;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                } 
            }

        });

    }
    
    


    public WebElement waitForElementToBeClickable(final By by, int timeOutPeriod) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        return webDriverWait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                try {
                    WebElement element = driver.findElement(by);
                    if (element.isEnabled() && element.isDisplayed())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public WebElement waitForElementToBeClickable(final WebElement element,
                                                  int timeOutPeriod) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);

        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {

                    if (element.isEnabled() && element.isDisplayed())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public WebElement waitForElementToBeEnabled(final WebElement element,
                                                int timeOutPeriod) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);

        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {

                    if (element.isEnabled())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public WebElement waitForElementToBeEnabled(final By by, int timeOutPeriod) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {
                    WebElement element = driver.findElement(by);
                    if (element.isEnabled())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public WebElement waitForOptionToBePopulatedInList(
            final WebElement dropdownList, int timeOutPeriod) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {
                    List<WebElement> options = dropdownList.findElements(By
                            .tagName("option"));
                    if (options.size() > 1) {
                        return dropdownList;
                    } else
                        return null;

                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public void waitForElementToDisappear(final By by, int timeOutPeriod) {

        FluentWait<By> fluentWait = new FluentWait<By>(by);
        fluentWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        fluentWait.withTimeout(timeOutPeriod, TimeUnit.SECONDS);
        fluentWait.until(new Predicate<By>() {
            public boolean apply(By by) {
                try {
                    return !driver.findElement(by).isDisplayed();

                } catch (NoSuchElementException ex) {
                    return true;
                } catch (StaleElementReferenceException ex) {
                    return true;
                }
            }
        });

    }

    public void bringElementInView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", element);

    }


    public void waitForElementToDisappear(final WebElement element,
                                          int timeOutPeriod) {

        FluentWait<WebElement> fluentWait = new FluentWait<WebElement>(element);
        fluentWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        fluentWait.withTimeout(timeOutPeriod, TimeUnit.SECONDS);
        fluentWait.until(new Predicate<WebElement>() {
            public boolean apply(WebElement element) {
                try {
                    return !element.isDisplayed();
                } catch (NoSuchElementException ex) {
                    return true;
                } catch (StaleElementReferenceException ex) {
                    return true;
                }
            }
        });
    }

    public void waitForAlert(int timeOutPeriod) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutPeriod);
        webDriverWait
                .ignoring(NoSuchElementException.class,
                        StaleElementReferenceException.class)
                .pollingEvery(10, TimeUnit.MILLISECONDS)
                .until(ExpectedConditions.alertIsPresent());

    }

    public String acceptAlert(int timeOutPeriod) {
        waitForAlert(timeOutPeriod);
        Alert alert = driver.switchTo().alert();
        String AlertMessage = alert.getText();
        alert.accept();
        return AlertMessage;
    }

    public String dismissAlert(int timeOutPeriod) {
        waitForAlert(timeOutPeriod);
        Alert alert = driver.switchTo().alert();
        String AlertMessage = alert.getText();
        alert.dismiss();
        return alert.getText();
    }


    /**
     * @param waitTime
     * @see pass value in seconds
     */
    public void explicitWait(int waitTime) {

        try {
            Thread.sleep(waitTime * 1000);
        } catch (InterruptedException e) {

        }
    }
    
    
}
