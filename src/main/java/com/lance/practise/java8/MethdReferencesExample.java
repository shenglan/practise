package com.lance.practise.java8;

import java.util.*;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Method Reference, 方法引用
 *
 * @author Shenglan Wang
 */
public class MethdReferencesExample {

    public static void main(String[] args) {
        Set<String> knownNames = new HashSet<>();
        // lamda
        Predicate<String> isKnown1 = t -> knownNames.contains(t);
        // method references
        Predicate<String> isKnown2 = knownNames::contains;


        Person person1 = new Person("Alice", 12);
        Person person2 = new Person("Tim", 13);
        Person[] people = new Person[] {person1, person2};

        // lamda
        Comparator<Person> byName1 = Comparator.comparing(p -> p.getName());
        Arrays.sort(people, byName1);

        // method references
        Comparator<Person> byName2 = Comparator.comparing(Person::getName);
        Arrays.sort(people, byName2);

        // Class::new, only when Class implements FunctionalInterface
        FunctionalInterfaceExample example = FunctionalInterfaceExampleImpl::new;
        example.read();
    }

    @Data
    @AllArgsConstructor
    static class Person {
        private String name;
        private int age;
    }
}

class FunctionalInterfaceExampleImpl implements FunctionalInterfaceExample {

    @Override public void read() {
        System.out.println("I am in read");
    }
}
