package loginForm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestLoginZingIDForm2 {
    private WebDriver webDriver;
    private String baseUrl = "https://id.zing.vn/";
    private String driverPath = "E:\\Library_JAR\\selenium\\chromedriver\\chromedriver.exe";

    WebElement emailField;
    WebElement passwordField;
    WebElement submit;
    List<WebElement> errorMessage;

    @BeforeMethod
    public void lunchBrowser() {
        System.out.println("Begin setup");
        System.setProperty("webdriver.chrome.driver", driverPath);
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(baseUrl);
    }

    @DataProvider(name = "login")
    public Object[][] dataSource() {
        return new Object[][]{{"tonyDG", "abc123123", "Tài khoản hoặc mật khẩu không đúng"},
                {"", "", "Bạn cần nhập thông tin này"},
                {"lady Gaga", "abc", "Vui lòng nhập mật khẩu dài 6-32 ký tự, có ký tự chữ số, chữ hoa và chữ thường"},
                {"Cho_Mot_Ngay_Nang_9x", "passowrd1", "Tài khoản hoặc mật khẩu không đúng"},};
    }

    @DataProvider(name = "login1")
    public Object[][] dataSource1() {
        return new Object[][]{{"hctien98", "cuchuoi^&^"}};
    }

    //    @DataProvider(name = "login1")
//    public Object[][] dataSource(Method method) {
//        Object[][] data = null;
//        if (method.getName().equals("testLogin1")) {
//            data = new Object[][]{{"tonyDG", "abc123123", "Tài khoản hoặc mật khẩu không đúng"},
//                    {"", "", "Bạn cần nhập thông tin này"},
//                    {"lady Gaga", "abc", "Vui lòng nhập mật khẩu dài 6-32 ký tự, có ký tự chữ số, chữ hoa và chữ thường"},
//                    {"Cho_Mot_Ngay_Nang_9x", "passowrd1", "Tài khoản hoặc mật khẩu không đúng"},};
//        } else if (method.getName().equals("testLogin2")) {
//            data = new Object[][]{{"hctien98", "cuchuoi^&^"}};
//        }
//        return data;
//    }


    @Test(dataProvider = "login")
    public void testLogin1(String email, String password, String expectedMessage) {
        String actualMessage = "";
        emailField = webDriver.findElement(By.id("login_account"));
        passwordField = webDriver.findElement(By.id("login_pwd"));
        submit = webDriver.findElement(By.xpath("//a[contains(text(),'Đăng nhập')]"));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submit.submit();

        errorMessage = webDriver.findElements(By.xpath("//div[@class='tipcontent']"));
        for (int i = 0; i < errorMessage.size() - 1; i++) {
            if (errorMessage.get(i).getText().equalsIgnoreCase("Tài khoản hoặc mật khẩu không đúng")) {
                actualMessage = "Tài khoản hoặc mật khẩu không đúng";
                break;
            } else if (errorMessage.get(i).getText().equalsIgnoreCase("Bạn cần nhập thông tin này")) {
                actualMessage = "Bạn cần nhập thông tin này";
                break;
            } else if (errorMessage.get(i).getText().equalsIgnoreCase("Vui lòng nhập mật khẩu dài 6-32 ký tự, có ký tự chữ số, chữ hoa và chữ thường")) {
                actualMessage = "Vui lòng nhập mật khẩu dài 6-32 ký tự, có ký tự chữ số, chữ hoa và chữ thường";
                break;
            }
        }
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(dataProvider = "login1")
    public void testLogin2(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submit.submit();

        String expectedURL = "https://id.zing.vn/";
        String actualURL = webDriver.getCurrentUrl();
        System.out.println(actualURL);

        System.out.println("login success");
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void testTitle() {
        String expectedTitle = "Zing ID - Zing Passport - Tài khoản Zing của VNG";
        String actualTitle = webDriver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void terminate() {
        System.out.println("End process");
        webDriver.close();
    }
}
