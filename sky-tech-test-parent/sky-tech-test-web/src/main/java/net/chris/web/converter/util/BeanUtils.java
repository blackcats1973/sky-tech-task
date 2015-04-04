package net.chris.web.converter.util;

/**
 * Provides common utilities on Java Beans (POJOs).
 * 
 * @author Chris Hern
 * 
 */
public final class BeanUtils {

    private BeanUtils() {
    }

    /**
     * Wrapper over the Spring copyProperties.Copy the property values of the given source bean into the target bean.
     * <p>
     * Note: It copies only if property names are same and leaves if the property names are different.
     * 
     * @see {@link org.springframework.beans.BeanUtils#copyProperties(Object, Object)}
     * 
     * @param p_fromBean
     *            - the source bean.
     * @param p_toBean
     *            - the target bean
     * @param <T>
     *            Generic Object
     * @param <U>
     *            Generic object
     */
    public static <T, U> void copyProperties(final T fromBean, final U toBean) {
        org.springframework.beans.BeanUtils.copyProperties(fromBean, toBean);
    }
}
