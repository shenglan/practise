package com.lance.practise.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Shenglan Wang
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private Animal animal;

    public InvocationHandlerImpl(Animal animal) {
        this.animal = animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass());
        System.out.println("In Proxy");
        Object res = method.invoke(animal, args);
        System.out.println("Out Proxy");
        return res;
    }

    public static void main(String[] args) {
        InvocationHandlerImpl handler = new InvocationHandlerImpl(new Cat());
        Animal animal = (Animal) Proxy
                .newProxyInstance(Animal.class.getClassLoader(), new Class[] { Animal.class },
                        handler);
        animal.speak();
    }
}
