package kr.autowired.guardian_tales_web.util;

import org.springframework.stereotype.Component;

@Component
public class ConvertUtil {

    public String byteToHex (final byte[] byteValue) {
        final StringBuffer stringBuffer = new StringBuffer(byteValue.length * 2);

        for (int i = 0; i < byteValue.length; i++) {
            final String hex = "0" + Integer.toHexString(0xFF & byteValue[i]);

            stringBuffer.append(hex.substring(hex.length() - 2));
        }

        return stringBuffer.toString();
    }

    public byte[] hexToByte (final String hex) {
        final byte[] byteValue = new byte[hex.length() / 2];

        for (int i = 0; i < byteValue.length; i++) {
            byteValue[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }

        return byteValue;
    }

}
