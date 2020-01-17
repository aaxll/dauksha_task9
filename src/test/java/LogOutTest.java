import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogOutTest extends TestBase {

    @Test
    public void userLogOutTest(){
        driver.get(adminPanelURL);
        loginPage.checkLoginStatus(adminEmail, adminPassword);
        adminPage.userLogOut();
        Assertions.assertEquals("http://open-eshop.stqa.ru/oc-panel/auth/login", driver.getCurrentUrl());
    }
}
