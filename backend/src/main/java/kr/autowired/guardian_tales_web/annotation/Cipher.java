package kr.autowired.guardian_tales_web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cipher {

    // 0: one-way, 1: two-way
    public int type ();

    // 0: encrypt, 1: decrypt
    public int mode ();

}
