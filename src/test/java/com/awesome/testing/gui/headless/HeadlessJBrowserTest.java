package com.awesome.testing.gui.headless;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class HeadlessJBrowserTest extends AbstractHeadlessTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new JBrowserDriver(Settings.builder().
                timezone(Timezone.EUROPE_WARSAW).build());
    }

    @Test
    public void jBrowserTest() {
        shouldSuccessfullyFindPostAndDisplayCommentsSection(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
