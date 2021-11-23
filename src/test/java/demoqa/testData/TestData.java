package demoqa.testData;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("ru"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress("guruqa");
    public String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public String address = faker.address().streetAddress();
    public String picture = "image.png";
}
