package lab2;

import lab2.serialize.SerializeJSON;
import lab2.serialize.SerializeTXT;
import lab2.serialize.SerializeXML;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person.Builder()
                .setFirstName("Max")
                .setLastName("Petrenko")
                .setAge(22)
                .setHeight(177)
                .setWeight(70)
                .createPerson();
        Person person2 = new Person.Builder()
                .setFirstName("Andrew")
                .setLastName("Melnyk")
                .setAge(35)
                .setHeight(185)
                .setWeight(78)
                .createPerson();

        Person person3 = new Person.Builder()
                .setFirstName("Bohdan")
                .setLastName("Kornienko")
                .setAge(29)
                .setHeight(197)
                .setWeight(90)
                .createPerson();

        Person person4 = new Person();
        Person person5 = new Person();
        Person person6 = new Person();

        SerializeJSON serialize1 = new SerializeJSON();
        SerializeXML serialize2 = new SerializeXML();
        SerializeTXT serialize3 = new SerializeTXT();

        try {
            serialize1.serializer(person1, new File("JSON.json"));
            serialize2.serializer(person2, new File("XML.XML"));
            serialize3.serializer(person3, new File("TXT.txt"));
        }
        catch (Exception error){
            error.printStackTrace();
        }

        try {
            person4 = serialize1.deserializer(new File("JSON.json"));
            person5 = serialize2.deserializer(new File("XML.XML"));
            person6 = serialize3.deserializer(new File("TXT.txt"));
        }
        catch (Exception error){
            error.printStackTrace();
        }

        System.out.println(person4);
        System.out.println(person5);
        System.out.println(person6);
    }
}