package kr.autowired.guardian_tales_web.common;

import kr.autowired.guardian_tales_web.annotation.Cipher;
import kr.autowired.guardian_tales_web.annotation.Exclude;
import kr.autowired.guardian_tales_web.util.CipherUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CompatibilityData<T> {

    private final Class<T> clazz;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final CipherUtil cipherUtil;

    public <P> T toSingle (final P p) {
        return this.toSingle(p, 1);
    }

    private <P> T toSingle (final P p, final int type) {
        try {
            final T t = (T) clazz.getConstructor().newInstance();
            final Field[] parameterFieldArray = p.getClass().getDeclaredFields();

            for (final Field parameterField : parameterFieldArray) {
                final Field field = t.getClass().getDeclaredField(parameterField.getName());

                parameterField.setAccessible(true);
                field.setAccessible(true);

                if (!this.isExclude(field, type)) {
                    field.set(t, this.toCipher(field, parameterField.get(p)));
                }
            }

            return t;
        } catch (final Exception exception) {
            throw new IllegalStateException(exception.getMessage());
        }
    }

    public <P> List<T> toMulti (final List<P> pList) {
        final List<T> tList = new ArrayList<T>();

        for (final P p : pList) {
            tList.add(this.toSingle(p, 2));
        }

        return tList;
    }

    private Object toCipher (final Field field, final Object parameterFieldValue) {
        final Cipher cipher = field.getAnnotation(Cipher.class);
        final boolean isCipher = field.isAnnotationPresent(Cipher.class);

        if (!isCipher) {
            return parameterFieldValue;
        }

        if (cipher.type() == 0) {
            return this.bCryptPasswordEncoder.encode(parameterFieldValue.toString());
        }

        if (cipher.mode() == 0) {
            return this.cipherUtil.encryptAESGCM(parameterFieldValue.toString());
        } else {
            return this.cipherUtil.decryptAESGCM(parameterFieldValue.toString());
        }
    }

    private boolean isExclude (final Field field, final int type) {
        final Exclude exclude = field.getAnnotation(Exclude.class);
        final boolean isExclude = field.isAnnotationPresent(Exclude.class);

        return isExclude && (exclude.type() == 0 || exclude.type() == type);
    }

}
