import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends TestBase {

    @Test
    @DisplayName("Login User")
    public void loginUserTest() {
        driver.get(loginPageURL);
        loginPage.loginUser(adminEmail, adminPassword);
        Assertions.assertEquals("Welcome - Open eShop", driver.getTitle());
    }



}
