package kr.autowired.guardian_tales_web.common;

import lombok.RequiredArgsConstructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CompatibilityData<T> {

    private final Class<T> clazz;

    public <P> T toSingle (final P p) {
        try {
            final T t = (T) clazz.getConstructor().newInstance();
            final Field[] parameterFieldArray = p.getClass().getDeclaredFields();

            for (final Field parameterField : parameterFieldArray) {
                Field field = t.getClass().getDeclaredField(parameterField.getName());

                parameterField.setAccessible(true);
                field.setAccessible(true);
                field.set(t, parameterField.get(p));
            }

            return t;
        } catch (final Exception exception) {
            throw new IllegalStateException(exception.getMessage());
        }
    }

    public <P> List<T> toMulti (final List<P> pList) {
        List<T> tList = new ArrayList<T>();

        for (final P p : pList) {
            tList.add(this.toSingle(p));
        }

        return tList;
    }

}
