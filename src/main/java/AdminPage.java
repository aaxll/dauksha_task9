import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminPage {
    private WebDriver driver;

    @FindBy(css = "a[href=\"#collapseOne\"]")
    private WebElement eShopAccordion;

    @FindBy(css = "a[title=\"Coupons\"]")
    private WebElement couponsAccordion;

    @FindBy(css = "a[href=\"http://open-eshop.stqa.ru/oc-panel/Coupon/create\"]")
    private WebElement newCouponBtn;

    @FindBy(css = "input[name=\"name\"]")
    private WebElement couponName;

    @FindBy(css = "input[name=\"valid_date\"]")
    private WebElement validDate;

    @FindBy(css = "input[name=\"number_coupons\"]")
    private WebElement numberOfCoupons;

    @FindBy(css = "button[name=\"submit\"]")
    private WebElement submitNewCouponBtn;

    @FindBy(css = "input[name=\"name\"]")
    private WebElement couponSearchBox;

    @FindBy(css = "form[method=\"get\"] button")
    private WebElement couponSearchBtn;

    @FindBy(css = "a[href*=\"oc-panel/Coupon/delete\"]")
    private WebElement couponDeleteBtn;

    @FindBy(css = "button.confirm")
    private WebElement couponDeleteConfirmBtn;

    @FindBy(css = "a[data-toggle=\"dropdown\"] > span.caret")
    private WebElement userDropDownMenuBtn;

    @FindBy(css = "a[href*=\"logout\"]")
    private WebElement userLogOutBtn;

    @FindBy(css = "div.table-responsive td")
    private List<WebElement> tableCell;

    @FindBy(css = "table.table.table-striped > thead tr")
    private WebElement tableSearchResultHeaders;

    @FindBy(css = "table.table.table-striped > tbody tr")
    private WebElement tableSearchResultRow;

    @FindBy(xpath = "//div//a[contains(text(), 'Fixed')]")
    private WebElement fixedDiscountTab;

    @FindBy(css = "div.alert.alert-success")
    private List<WebElement> couponCreationSuccessMsg;





    public AdminPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public AdminPage clickEShopBtn (){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(eShopAccordion));
        eShopAccordion.click();
        return new AdminPage(driver);
    }

    public AdminPage clickCouponsBtn (){
        couponsAccordion.click();
        return new AdminPage(driver);
    }

    public AdminPage clickNewCouponBtn (){
        newCouponBtn.click();
        return new AdminPage(driver);
    }

    public AdminPage clickSubmitNewCouponBtn (){
        submitNewCouponBtn.click();
        return new AdminPage(driver);
    }

    public AdminPage setCouponName (String value){
        try {
            Thread.sleep(500,0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fixedDiscountTab.click();
        couponName.sendKeys(value);
        return this;
    }

    public AdminPage setValidDate (String value){
        validDate.clear();
        validDate.sendKeys(value);
        return this;
    }

    public AdminPage setNumberOfCoupons (String value){
        numberOfCoupons.clear();
        numberOfCoupons.sendKeys(value);
        return this;
    }

    public AdminPage setCouponNameToSearchBox (String value){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(couponSearchBox));
        couponSearchBox.clear();
        couponSearchBox.sendKeys(value);
        return this;
    }

    public AdminPage clickCouponSearchBtn (){
        couponSearchBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(tableSearchResultHeaders));
        return new AdminPage(driver);
    }

    public AdminPage clickCouponDeleteBtn (){
        try {
            Thread.sleep(500,0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        couponDeleteBtn.click();
        return new AdminPage(driver);
    }

    public AdminPage clickCouponDeleteConfirmBtn (){
        try {
            Thread.sleep(500,0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        couponDeleteConfirmBtn.click();
        return new AdminPage(driver);
    }

    public AdminPage clickUserDropDownMenuBtn (){
        userDropDownMenuBtn.click();
        return new AdminPage(driver);
    }

    public AdminPage clickUserLogOutBtn (){
        userLogOutBtn.click();
        return new AdminPage(driver);
    }

    public AdminPage addNewCoupon (String name, String date, String count){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        this.clickEShopBtn();
        wait.until(ExpectedConditions.elementToBeClickable(couponsAccordion));
        this.clickCouponsBtn();
        wait.until(ExpectedConditions.elementToBeClickable(newCouponBtn));
        this.clickNewCouponBtn();
        this.setCouponName(name);
        this.setValidDate(date);
        this.setNumberOfCoupons(count);
        this.clickSubmitNewCouponBtn();
        return new AdminPage(driver);

    }

    public AdminPage couponSearch (String name){
        this.setCouponNameToSearchBox(name);
        this.clickCouponSearchBtn();
        return new AdminPage(driver);
    }

    public AdminPage couponDelete (){
        this.clickCouponDeleteBtn();
        this.clickCouponDeleteConfirmBtn();
        return new AdminPage(driver);
    }

    public AdminPage userLogOut(){
        this.clickUserDropDownMenuBtn();
        this.clickUserLogOutBtn();
        return new AdminPage(driver);
    }

    public String getCouponNameFromTableCell(){
       return tableCell.get(0).getText();
    }

    public int getTableCellCount(){
        return tableCell.size();
    }

    public int getCouponCreationSuccessMsgCount(){
        return couponCreationSuccessMsg.size();
    }

    public String getCouponSearchBoxPlaceholder(){
        return couponSearchBox.getAttribute("value");
    }

    public String getTableSearchResultRowVisibilityStatus(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(tableSearchResultRow));
        return tableSearchResultRow.getAttribute("style");
    }


}
