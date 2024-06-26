package kr.autowired.guardian_tales_web.util;

import kr.autowired.guardian_tales_web.common.CipherSecret;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@Slf4j
@Component
@RequiredArgsConstructor
public class CipherUtil {

    private final String TRANSFORMATION = "AES/GCM/NoPadding";
    private final ConvertUtil convertUtil;
    private final CipherSecret cipherSecret;

    public String encryptAESGCM (final String plainValue) {
        if (plainValue == null || plainValue.isEmpty()) {
            return null;
        }

        try {
            final Cipher cipher = this.getCipherInstance(Cipher.ENCRYPT_MODE);
            final byte[] encryptValue = cipher.doFinal(plainValue.getBytes());

            return this.convertUtil.byteToHex(encryptValue);
        } catch (final Exception exception) {
            log.error(exception.getMessage());

            throw new IllegalStateException("Encrypt failed.");
        }
    }

    public String decryptAESGCM (final String encryptedValue) {
        if (encryptedValue == null || encryptedValue.isEmpty()) {
            return null;
        }

        try {
            final Cipher cipher = this.getCipherInstance(Cipher.DECRYPT_MODE);
            final byte[] decryptValue = cipher.doFinal(this.convertUtil.hexToByte(encryptedValue));

            return new String(decryptValue);
        } catch (final Exception exception) {
            log.error(exception.getMessage());

            throw new IllegalStateException("Decrypt failed.");
        }
    }

    private Cipher getCipherInstance (final int mode) throws Exception {
        final Cipher cipher = Cipher.getInstance(this.TRANSFORMATION);
        final SecretKeySpec secretKeySpec = new SecretKeySpec(this.cipherSecret.getSecret().getBytes(), "AES");
        final GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(128, this.cipherSecret.getIv().getBytes());

        cipher.init(mode, secretKeySpec, gcmParameterSpec);

        return cipher;
    }

}
