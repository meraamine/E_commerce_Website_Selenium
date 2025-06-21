package utils;
import java.util.UUID;

public class DataGenerator {

    // Generate random email using UUID
    public static String generateRandomEmail() {
        return "user_" + UUID.randomUUID().toString().substring(0, 8) + "@test.com";
    }

    // Generate random name with prefix (e.g., "Mera" becomes "MeraA1xF")
    public static String generateRandomName(String baseName) {
        String randomSuffix = UUID.randomUUID().toString().substring(0, 4);
        return baseName + randomSuffix;
    }
}
