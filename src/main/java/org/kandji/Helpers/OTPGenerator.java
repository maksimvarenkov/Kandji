package org.kandji.Helpers;

import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;
import org.apache.commons.codec.binary.Base32;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.time.Instant;

public class OTPGenerator {

    public String generateOTPPassword() {
        String token = new ConfigReader().getProperty("user_secret_token");

        Base32 base32 = new Base32();
        byte[] secretKeyBytes = base32.decode(token);
        SecretKey key = new SecretKeySpec(secretKeyBytes, "HmacSHA1");

        // By default TOTP generator uses 30s window
        TimeBasedOneTimePasswordGenerator totp = new TimeBasedOneTimePasswordGenerator();

        Instant now = Instant.now();
        int otp;
        try {
            otp = totp.generateOneTimePassword(key, now);
        } catch (InvalidKeyException e) {
            throw new RuntimeException("Invalid Secret Key for HMAC-SHA1", e);
        }

        System.out.println("OTP:" + String.format("%06d", otp));

        return String.format("%06d", otp);
    }

}
