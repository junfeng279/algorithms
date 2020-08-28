package com.summer.algorithms.base.ioc;

/**
 * @author adminstor
 */
public class ConstructorArg {
    private boolean isRef;
    private Class type;
    private Object arg;

    public ConstructorArg(boolean isRef, Class type, Object arg) {
        this.isRef = isRef;
        this.type = type;
        this.arg = arg;
    }

    public boolean isRef() {
        return isRef;
    }

    public void setRef(boolean ref) {
        isRef = ref;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public Object getArg() {
        return arg;
    }

    public void setArg(Object arg) {
        this.arg = arg;
    }
}

