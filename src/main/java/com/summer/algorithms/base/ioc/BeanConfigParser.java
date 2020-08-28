package com.summer.algorithms.base.ioc;

import java.util.List;

/**
 * @author adminstor
 */
public interface BeanConfigParser {
    /**解析
     * @param scanPackage scanPackage
     * @return BeanDefinition
     */
    List<BeanDefinition> parse(String scanPackage) throws ClassNotFoundException;
}
