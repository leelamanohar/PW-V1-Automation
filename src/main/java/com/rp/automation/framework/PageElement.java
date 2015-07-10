package com.rp.automation.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageElement {
    private By by;
    private String name;
    private boolean isSlowLoadableComponent;
    private WaitType waitType;
    private int timeOut;
    private WebElement webElement;

    public WebElement getWebElement() {
        return webElement;
    }

    public void setWebElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public By getBy() {
        return by;
    }

    public void setBy(By by) {
        this.by = by;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSlowLoadableComponent() {
        return isSlowLoadableComponent;
    }

    public void setSlowLoadableComponent(boolean isSlowLoadableComponent) {
        this.isSlowLoadableComponent = isSlowLoadableComponent;
    }

    public WaitType getWaitType() {
        return waitType;
    }

    public void setWaitType(WaitType waitType) {
        this.waitType = waitType;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public PageElement(By by, String name) {
        super();
        this.by = by;
        this.name = name;

    }

    public PageElement(By by, String name, boolean isSlowLoadableComponent,
                       WaitType waitType, int timeOut) {
        super();
        this.by = by;
        this.name = name;
        this.isSlowLoadableComponent = isSlowLoadableComponent;
        this.waitType = waitType;
        this.timeOut = timeOut;

    }
    
        
    @Override
    public String toString() {
        return "PageElement [name=" + name + "]";
    }

}
