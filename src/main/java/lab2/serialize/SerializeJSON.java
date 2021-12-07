package lab2.serialize;

import lab2.Person;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class SerializeJSON {
    ObjectMapper mapper;

    public SerializeJSON() {
        mapper = new ObjectMapper();
    }

    public void serializer(Person obj, File file) throws IOException {
        try {
            mapper.writeValue(file, obj);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Person deserializer(File file) {
        try {
            return mapper.readValue(file, Person.class);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}