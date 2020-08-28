package com.summer.algorithms.base.ioc;

import java.util.List;

/**
 * @author adminstor
 */
public class AnnotationApplicationContext implements ApplicationContext {
    private BeanFactory beanFactory;
    private BeanConfigParser beanConfigParser;

    public AnnotationApplicationContext() throws ClassNotFoundException {
        this.beanFactory = new BeanFactory();
        this.beanConfigParser = new AnnotationBeanConfigParser();
        loadBeanDefinitions();
    }

    private void loadBeanDefinitions() throws ClassNotFoundException {
        List<BeanDefinition> beanDefinitions = this.beanConfigParser.parse("");
        this.beanFactory.addBeanDefinitions(beanDefinitions);
    }


    @Override
    public Object getBean(String beanId) {
        return beanFactory.getBean(beanId);
    }
}
