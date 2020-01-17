package listeners;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverListener implements WebDriverEventListener {

   // Logger logger = Logger.getLogger(WebDriverListener.class);
   Logger logger = LoggerFactory.getLogger(WebDriverListener.class);

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Navigate to page from: " + webDriver.getCurrentUrl());

    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Navigated to page: " + webDriver.getCurrentUrl());

    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        System.out.println("Navigate back to previous page from: " + webDriver.getCurrentUrl());

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("Navigated back to previous page: " + webDriver.getCurrentUrl());

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        System.out.println("Navigate forward to next page from: " + webDriver.getCurrentUrl());

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("Navigated forward to next page: " + webDriver.getCurrentUrl());

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("Before find by " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("After find by " + by);
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("Before click on  " + webElement.toString());
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("After click on  " + webElement.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        logger.error("Error: " + throwable );
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        logger.info("Before Get Text on  " + webElement.toString());
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        logger.info("After Get Text on  " + webElement.toString());

    }
}
