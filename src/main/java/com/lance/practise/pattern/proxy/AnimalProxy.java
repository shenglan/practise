package com.lance.practise.pattern.proxy;

/**
 * @author Shenglan Wang
 */
public class AnimalProxy implements Animal{
    private Animal animal;

    public AnimalProxy(Animal animal) {
        this.animal = animal;
    }

    @Override public void speak() {
        System.out.println("Start proxy...");
        animal.speak();
        System.out.println("End Proxy...");
    }

    public static void main(String[] args) {
        Animal animal = new AnimalProxy(new Cat());
        animal.speak();
    }
}
