package com.lance.practise.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Shenglan Wang
 */
public class AnimalFactory implements InvocationHandler {

    public Cat create() {
        return (Cat) Proxy.newProxyInstance(Animal.class.getClassLoader(),
                new Class[] { Animal.class }, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("In Proxy");
        method.invoke(proxy, args);
        System.out.println("Out Proxy");
        return null;
    }

    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();
        Animal animal = factory.create();
        animal.speak();
    }
}
