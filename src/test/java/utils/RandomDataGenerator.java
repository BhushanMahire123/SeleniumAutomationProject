package utils;

public class RandomDataGenerator {

    public static String generateEmail() {

        return "user" + System.currentTimeMillis() + "@mailinator.com";
    }
}