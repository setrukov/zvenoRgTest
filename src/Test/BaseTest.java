package Test;
import Utils.JsonUtils;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;


import static com.codeborne.selenide.Selenide.open;

abstract public class BaseTest {
    private static String baseUrl = JsonUtils.getValue("config.json","url");
    public void setUp() {
        open(baseUrl);
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
