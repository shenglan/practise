package com.lance.practise.pattern.builder;

/**
 * 设计模式: Builder模式
 */
public class Person {

    private final String firstName;

    private final String lastName;

    private final String hobby;

    private final int age;

    private final boolean canSwim;

    public static class PersonBuilder {

        private final String firstName;

        private final String lastName;

        // Optional field
        private String hobby = "sing";

        private int age = 10;

        private boolean canSwim = false;

        public PersonBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public PersonBuilder setHobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder setCanSwim(boolean canSwim) {
            this.canSwim = canSwim;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    private Person(PersonBuilder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        hobby = builder.hobby;
        age = builder.age;
        canSwim = builder.canSwim;
    }

    @Override
    public String toString() {
        return "BuilderPattern{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hobby='" + hobby + '\'' +
                ", age=" + age +
                ", canSwim=" + canSwim +
                '}';
    }
}
