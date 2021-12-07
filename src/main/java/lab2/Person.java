package lab2;

import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private int height;
    private int weight;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public Person() {

    }

    private Person(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        age = builder.age;
        height = builder.height;
        weight = builder.weight;
    }

    public static class Builder {

        private String firstName;
        private String lastName;
        private int age;
        private int height;
        private int weight;

        public Builder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        /**
         *
         * @param age - how old are person
         * @return Builder instance
         * @throws IllegalArgumentException - if number of pages is less than or equal zero
         */
        public Builder setAge(int age) throws IllegalArgumentException{
            if (age >= 0) {
                this.age = age;
            } else {
                throw new IllegalArgumentException("Illegal Argument");
            }
            return this;
        }

        public Builder setHeight(int height) throws IllegalArgumentException{
            if (height > 0) {
                this.height = height;
            } else {
                throw new IllegalArgumentException("Illegal Argument");
            }
            return this;
        }

        public Builder setWeight(int weight) throws IllegalArgumentException{
            if (weight > 0) {
                this.weight = weight;
            } else {
                throw new IllegalArgumentException("Illegal Argument");
            }
            return this;
        }

        public Person createPerson() {
            return new Person(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) &&
                age == person.age &&
                height == person.height &&
                weight == person.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, height, weight);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name= " + firstName +
                " ,surname= " + lastName +
                " ,age= " + age +
                " ,height= " + height +
                " ,weight= " + weight +
                " }";
    }
}