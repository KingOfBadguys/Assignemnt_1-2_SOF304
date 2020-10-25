package modelTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CustomerTest.class, InvoiceTest.class, ProductTest.class, UserTest.class })
public class AllTests {

}
