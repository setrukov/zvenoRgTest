package Test;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;


import static com.codeborne.selenide.Selenide.open;

abstract public class BaseTest {
    private final static String BASE_URL = "https://demo.zveno.io";
    public void setUp() {
        open(BASE_URL);
    }

    @Before
    public void init() {
        setUp();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }



}
