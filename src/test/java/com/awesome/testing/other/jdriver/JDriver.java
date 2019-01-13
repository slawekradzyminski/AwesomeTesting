package com.awesome.testing.other.jdriver;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.Timezone;
import org.junit.Test;

public class JDriver {

    @Test
    public void example() {
        JBrowserDriver driver = new JBrowserDriver(Settings.builder().
                timezone(Timezone.EUROPE_WARSAW).build());
        driver.get("http://www.awesome-testing.com");
        System.out.println(driver.getStatusCode());
        System.out.println(driver.getPageSource());
        driver.quit();
    }

}
