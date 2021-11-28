package demoqa.test;

import com.codeborne.selenide.Configuration;
import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import demoqa.helpers.Attach;

import static java.lang.String.format;


public class TestBase {

    @BeforeAll
    static void beforeAll() {
        CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);
        String login = credentials.login();
        String password = credentials.password();
        String url = System.getProperty("url", "selenoid.autotests.cloud/wd/hub/");

        Configuration.browserSize = "1920x1080";
        Configuration.remote = format("https://%s:%s@%s", login, password, url);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
