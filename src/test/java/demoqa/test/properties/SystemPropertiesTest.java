package demoqa.test.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("properties")
public class SystemPropertiesTest {
    @Test
    void someTest(){
        String value = System.getProperty("value");
        System.out.println(value);
    }

    @Test
    void someTest1(){
        String value = System.getProperty("browser", "firefox");
        System.out.println(value);
    }
}
