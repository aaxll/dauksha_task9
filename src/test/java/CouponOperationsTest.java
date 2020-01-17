import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CouponOperationsTest extends TestBase {

    @Test
    @Order(1)
    public void searchAndDeleteCouponTest() {
        driver.get(adminPanelURL);
        loginPage.checkLoginStatus(adminEmail, adminPassword);
        driver.get(couponsPageURL);
        adminPage.couponSearch(couponNameField);
        adminPage.couponDelete();
        adminPage.couponSearch(couponNameField);
        Assertions.assertEquals(0, adminPage.getTableCellCount());
    }

    @Test
    @Order(2)
    public void searchCouponResultTest() {
        driver.get(adminPanelURL);
        loginPage.checkLoginStatus(adminEmail, adminPassword);
        adminPage.addNewCoupon(couponNameField, couponDateField, couponCountField);
        adminPage.couponSearch(couponNameField);
        Assertions.assertEquals(7, adminPage.getTableCellCount());
    }

    @Test
    @Order(3)
    public void searchCouponPlaceholderTest() {
        driver.get(adminPanelURL);
        loginPage.checkLoginStatus(adminEmail, adminPassword);
        driver.get(couponsPageURL);
        adminPage.couponSearch(couponNameField);
        Assertions.assertEquals(couponNameField, adminPage.getCouponSearchBoxPlaceholder());
    }

    @Test
    @Order(4)
    public void couponSearchResultRowVisibilityTest() {
        driver.get(adminPanelURL);
        loginPage.checkLoginStatus(adminEmail, adminPassword);
        driver.get(couponsPageURL);
        adminPage.couponSearch(couponNameField);
        adminPage.couponDelete();
        Assertions.assertEquals("display: none;", adminPage.getTableSearchResultRowVisibilityStatus());
    }
}
