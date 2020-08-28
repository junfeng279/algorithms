package com.summer.algorithms.base.ioc;

/**
 * @author adminstor
 */
public interface ApplicationContext {
    /**
     * 获取bean
     * @param beanId beanId
     * @return Object
     */
    Object getBean(String beanId);
}
