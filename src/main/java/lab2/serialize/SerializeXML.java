package lab2.serialize;

import com.fasterxml.jackson.xml.XmlMapper;
import lab2.Person;

import java.io.File;
import java.io.IOException;

public class SerializeXML {
    XmlMapper object;

    public SerializeXML() {
        object = new XmlMapper();
    }

    public void serializer(Person obj, File file) throws IOException {
        try {
            object.writeValue(file, obj);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Person deserializer(File file) {
        try {
            return object.readValue(file, Person.class);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
