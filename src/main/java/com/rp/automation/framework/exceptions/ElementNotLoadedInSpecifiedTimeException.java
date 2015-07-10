package com.rp.automation.framework.exceptions;

@SuppressWarnings("serial")
public class ElementNotLoadedInSpecifiedTimeException extends RuntimeException {

    public ElementNotLoadedInSpecifiedTimeException(String element,
                                                    String timeout) {
        super(
                "Element "
                        + element
                        + " was not loaded in specified timeout of "
                        + timeout
                        + " seconds kindly refer attached screen shot for more clarification");
    }

    public ElementNotLoadedInSpecifiedTimeException(String element,
                                                    String timeout, Exception cause) {
        super(
                "Element "
                        + element
                        + " was not loaded in specified timeout of "
                        + timeout
                        + " seconds kindly refer attached screen shot for more clarification",
                cause);
    }

    public ElementNotLoadedInSpecifiedTimeException(String element,
                                                    int timeout, Exception cause) {
        super(
                "Element "
                        + element
                        + " was not loaded in specified timeout of "
                        + timeout
                        + " seconds kindly refer attached screen shot for more clarification",
                cause);
    }

    public ElementNotLoadedInSpecifiedTimeException() {
        super("Element not loaded in specified timeout");
    }

}
