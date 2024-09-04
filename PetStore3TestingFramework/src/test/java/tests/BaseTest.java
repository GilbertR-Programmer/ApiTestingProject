package tests;

import config.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BaseTest {

    private static final String BASE_URI = AppConfig.getBaseUri();

    @Test
    public void test1() {
        Assertions.assertEquals("testString", AppConfig.getTestString());
    }
}
