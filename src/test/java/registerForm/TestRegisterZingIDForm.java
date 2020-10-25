package registerForm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestRegisterZingIDForm {
    private WebDriver webDriver;
    private String baseUrl = "https://id.zing.vn/v2/register";
    private String driverPath = "E:\\Library_JAR\\selenium\\chromedriver\\chromedriver.exe";

    WebElement fullNameField;
    WebElement usernameField;
    WebElement passwordField;
    WebElement rePasswordField;
    List<WebElement> errorMessage;

    @BeforeMethod
    public void lunchBrowser() {
        System.out.println("Begin setup");

        System.setProperty("webdriver.chrome.driver", driverPath);
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(baseUrl);

        fullNameField = webDriver.findElement(By.id("regacc_fullname"));
        usernameField = webDriver.findElement(By.id("regacc_account"));
        passwordField = webDriver.findElement(By.id("regacc_pwd"));
        rePasswordField = webDriver.findElement(By.id("regacc_re_pwd"));
        errorMessage = webDriver.findElements(By.xpath("//div[@class='tipcontent']"));

    }
    @Test
    public void testNull(){
        String actualMessage ="";

        fullNameField.sendKeys("");
        usernameField.sendKeys("");
        passwordField.sendKeys("");
        rePasswordField.sendKeys("");

        for(int i=0; i<errorMessage.size()-1;i++){
           if(errorMessage.get(i).getText().equals("Bạn cần nhập thông tin này")){
               actualMessage = "Bạn cần nhập thông tin này";
           }
        }

        String expectedMessage = "Bạn cần nhập thông tin này";

        Assert.assertEquals(actualMessage,expectedMessage);

    }
    @Test
    public void testSizeText(){
        String actualMessage ="";
        String expectedMessage="";

        fullNameField.sendKeys("Cong tu bot");
        usernameField.sendKeys("user");
        passwordField.sendKeys("pass");
        rePasswordField.sendKeys("pass");

        for(int i=0; i<errorMessage.size()-1;i++){
            if(errorMessage.get(i).getText().equals("Tên tài khoản từ 6-24 ký tự")){
                actualMessage = errorMessage.get(i).getText();
                expectedMessage ="Tên tài khoản từ 6-24 ký tự";
                break;
            }else if(errorMessage.get(i).getText().equals("Vui lòng nhập mật khẩu dài 6-32 ký tự, có ký tự chữ số, chữ hoa và chữ thường")){
                actualMessage = errorMessage.get(i).getText();
                expectedMessage = "Vui lòng nhập mật khẩu dài 6-32 ký tự, có ký tự chữ số, chữ hoa và chữ thường";
                break;
            }
        }
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void testRePassword(){
        String actualMessage ="";
        String expectedMessage="";

        fullNameField.sendKeys("Cong tu bot");
        usernameField.sendKeys("username12301");
        passwordField.sendKeys("password12B3");
        rePasswordField.sendKeys("password12B55");

//        for(int i=0; i<errorMessage.size()-1;i++){
//            if(errorMessage.get(i).getText().equals("Xác nhận mật khẩu không đúng")){
//                actualMessage = errorMessage.get(i).getText();
//                expectedMessage ="Xác nhận mật khẩu không đúng";
//                break;
//            }
//        }
        actualMessage = errorMessage.get(13).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void testRegisterSuccess(){
        String actualURL ="";
        String expectedURL="https://id.zing.vn/v2/register";

        fullNameField.sendKeys("Cong tu bot");
        usernameField.sendKeys("username12301a");
        passwordField.sendKeys("password12B3");
        rePasswordField.sendKeys("password12B3");

        actualURL = webDriver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public void testValidUsername(){
        WebElement validUser = webDriver.findElement(By.xpath("//span[@class='account_valid']"));
        WebElement invalidUser = webDriver.findElement(By.xpath("//span[@class='account_valid']"));

        String display = validUser.getAttribute("style");
        String display2 = invalidUser.getAttribute("style");

        fullNameField.sendKeys("Cong tu bot");
        usernameField.sendKeys("username11");
        passwordField.sendKeys("password12B3");
        rePasswordField.sendKeys("password12B55");

        if(display!=null){
            Assert.assertTrue(true);
        }else if(display2!=null){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testTitle(){
        String actual= webDriver.getTitle();
        String expectedTitle = "Zing ID - Zing Passport - Tài khoản Zing của VNG";
        Assert.assertEquals(actual,expectedTitle);
    }

    @AfterMethod
    public void terminate(){
        System.out.println("End Process");
        webDriver.close();
    }
}
