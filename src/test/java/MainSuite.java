import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
        LoginPageTest.class,
        CouponCreateTest.class,
        CouponOperationsTest.class,
        LogOutTest.class
})

public class MainSuite {
}
