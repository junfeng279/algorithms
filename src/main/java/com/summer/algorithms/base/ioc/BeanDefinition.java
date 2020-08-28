package com.summer.algorithms.base.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adminstor
 */
public class BeanDefinition {
    private String id;
    private String className;
    private List<ConstructorArg> constructorArgs = new ArrayList<>();
    private Scope scope = Scope.SINGLETON;
    private boolean lazyInit = false;

    public BeanDefinition(String id, String className, List<ConstructorArg> constructorArgs, Scope scope, boolean lazyInit) {
        this.id = id;
        this.className = className;
        this.constructorArgs = constructorArgs;
        this.scope = scope;
        this.lazyInit = lazyInit;
    }

    public boolean isSingleton(){
        return scope.equals(Scope.SINGLETON);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ConstructorArg> getConstructorArgs() {
        return constructorArgs;
    }

    public void setConstructorArgs(List<ConstructorArg> constructorArgs) {
        this.constructorArgs = constructorArgs;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }
}
