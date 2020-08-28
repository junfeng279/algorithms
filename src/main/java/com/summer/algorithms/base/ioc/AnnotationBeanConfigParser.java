package com.summer.algorithms.base.ioc;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author adminstor
 */
public class AnnotationBeanConfigParser implements BeanConfigParser {
    @Override
    public List<BeanDefinition> parse(String scanPackages) throws ClassNotFoundException {
        Class<?> scanBasePackageClass = AnnotationBeanConfigParser.class;
        String scanBasePackage = scanBasePackageClass.getPackage().getName();
        //类所在的class path物理路径
        String classPath = getClassPath(scanBasePackageClass);
        File classPathDirectory = new File(classPath);
        File scanBasePackageDirectory = new File(classPathDirectory, scanBasePackage.replace('.', '/'));
        //获取所有的Class文件
        File[] classFiles = scanBasePackageDirectory.listFiles(file -> {
            return file.isFile() && file.getName().endsWith(".class");
        });

        System.out.println("class path : " + classPath);
        System.out.println("scan base package : " + scanBasePackage);
        System.out.println("scan class files :" + Stream.of(classFiles).map(File::getName).collect(Collectors.joining(",")));

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        List<Class<?>> targetClass = new LinkedList<>();
        for(File classFile : classFiles){
            String simpleClassName = classFile.getName().substring(0, classFile.getName().lastIndexOf("."));
            String className = scanBasePackage+"."+simpleClassName;
            //加载所有类
            Class<?> loadClass = classLoader.loadClass(className);
            //判断是否存在MyBean注解
            if(loadClass.isAnnotationPresent(MyBean.class)){
                targetClass.add(loadClass);
            }
        }
        List<BeanDefinition> definitionList = new ArrayList<>();
        for (Class<?> aClass : targetClass) {
            MyBean myBean = aClass.getAnnotation(MyBean.class);
            String classId = myBean.value();
            BeanDefinition beanDefinition = new BeanDefinition(classId, aClass.getName(), Collections.emptyList(), Scope.SINGLETON, false);
            definitionList.add(beanDefinition);
        }
        return definitionList;
    }

    private String getClassPath(Class<?> type) {
        return type.getProtectionDomain().getCodeSource().getLocation().getPath().substring(1);
    }
}
