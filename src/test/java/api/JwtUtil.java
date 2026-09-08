package api;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class JwtUtil {

    private static final String SECRET = "supersecretkey123";

    public static String generateToken() {

        try {

            // JWT Header
            String header = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";

            // JWT Payload
            String payload = "{}";

            // Base64 URL encode header
            String encodedHeader = Base64.getUrlEncoder()
                    .withoutPadding()
                    .encodeToString(
                            header.getBytes(StandardCharsets.UTF_8)
                    );

            // Base64 URL encode payload
            String encodedPayload = Base64.getUrlEncoder()
                    .withoutPadding()
                    .encodeToString(
                            payload.getBytes(StandardCharsets.UTF_8)
                    );

            // Header.Payload
            String data = encodedHeader + "." + encodedPayload;

            // Create HMAC SHA256 signature
            Mac mac = Mac.getInstance("HmacSHA256");

            SecretKeySpec secretKey =
                    new SecretKeySpec(
                            SECRET.getBytes(StandardCharsets.UTF_8),
                            "HmacSHA256"
                    );

            mac.init(secretKey);

            byte[] signature = mac.doFinal(
                    data.getBytes(StandardCharsets.UTF_8)
            );

            // Base64 URL encode signature
            String encodedSignature =
                    Base64.getUrlEncoder()
                            .withoutPadding()
                            .encodeToString(signature);

            // Final JWT
            return data + "." + encodedSignature;

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to generate JWT token",
                    e
            );
        }
    }
}