package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void before() {
        DriverFactory.startDriver();
    }

    @After
    public void after() {
        DriverFactory.stopDriver();
    }


}
