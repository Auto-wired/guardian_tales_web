package kr.autowired.guardian_tales_web.service;

import kr.autowired.guardian_tales_web.common.CompatibilityData;

public abstract class CommonService {

    protected abstract <T> CompatibilityData<T> getCompatibilityData (final Class<T> clazz);

}
