import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CouponCreateTest extends TestBase {

    @Test
    @Order(1)
    public void addNewCouponTest(){
        driver.get(adminPanelURL);
        loginPage.checkLoginStatus(adminEmail, adminPassword);
        adminPage.addNewCoupon(couponNameField, couponDateField, couponCountField);
        adminPage.couponSearch(couponNameField);
        Assertions.assertEquals(couponNameField, adminPage.getCouponNameFromTableCell());
    }

    @Test
    @Order(2)
    public void addNewCouponSuccessMsgTest(){
        driver.get(adminPanelURL);
        loginPage.checkLoginStatus(adminEmail, adminPassword);
        driver.get(couponsPageURL);
        adminPage.couponSearch(couponNameField);
        adminPage.couponDelete();
        adminPage.addNewCoupon(couponNameField, couponDateField, couponCountField);
        Assertions.assertEquals(1, adminPage.getCouponCreationSuccessMsgCount());
    }

}
