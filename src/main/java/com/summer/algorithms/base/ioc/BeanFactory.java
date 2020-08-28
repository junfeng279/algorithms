package com.summer.algorithms.base.ioc;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author adminstor
 */
public class BeanFactory {
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();

    public void addBeanDefinitions(List<BeanDefinition> beanDefinitionList){
        for(BeanDefinition beanDefinition : beanDefinitionList){
            this.beanDefinitions.putIfAbsent(beanDefinition.getId(), beanDefinition);
        }

        for(BeanDefinition beanDefinition: beanDefinitionList){
            if(!beanDefinition.isLazyInit() && beanDefinition.isSingleton()){
                createBean(beanDefinition);
            }
        }
    }

    public Object getBean(String beanId){
        BeanDefinition beanDefinition = beanDefinitions.get(beanId);
        if(beanDefinition == null){
            System.out.println("Bean is not defined: " + beanId);
            return null;
        }
        return createBean(beanDefinition);
    }

    private Object createBean(BeanDefinition beanDefinition) {
        if(beanDefinition.isSingleton() && singletonObjects.contains(beanDefinition.getId())){
            return singletonObjects.get(beanDefinition.getId());
        }
        Object bean = null;
        try {
            Class beanClass = Class.forName(beanDefinition.getClassName());
            List<ConstructorArg> args = beanDefinition.getConstructorArgs();
            if(args.isEmpty()){
                bean = beanClass.newInstance();
            }else{
                Class[] argClasses = new Class[args.size()];
                Object[] argObject = new Object[args.size()];
                for(int i=0; i<args.size(); i++){
                    ConstructorArg arg = args.get(i);
                    if(!arg.isRef()){
                        argClasses[i] = arg.getClass();
                        argObject[i] = arg.getArg();
                    }else{
                        BeanDefinition refBeanDefinition = beanDefinitions.get(arg.getArg());
                        if(refBeanDefinition == null){
                            System.out.println("Bean is not defined: " + arg.getArg());
                            break;
                        }
                        argClasses[i] = Class.forName(refBeanDefinition.getClassName());
                        argObject[i] = createBean(refBeanDefinition);
                    }
                }
                bean = beanClass.getConstructor(argClasses).newInstance(argObject);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        if(bean != null && beanDefinition.isSingleton()){
            singletonObjects.putIfAbsent(beanDefinition.getId(), bean);
            return singletonObjects.get(beanDefinition.getId());
        }
        return bean;
    }
}
