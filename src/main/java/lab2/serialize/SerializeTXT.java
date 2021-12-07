package lab2.serialize;

import lab2.Person;

import java.io.*;

public class SerializeTXT {

    public void serializer(Person obj, File file) throws IOException {
        try{
            FileWriter fw = new FileWriter(file);
            String str = obj.toString();
            fw.write(str);
            fw.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Person deserializer(File file) throws IOException {
        try (BufferedReader fr = new BufferedReader(new FileReader(file))) {
            String str = null;
            if ((str = fr.readLine()) != null && str.length() != 0) {
                String[] values = str.split(" ");
                return new Person.Builder().setFirstName(values[1]).setLastName(values[3]).setAge(Integer.parseInt(values[5]))
                        .setWeight(Integer.parseInt(values[7])).setHeight(Integer.parseInt(values[9])).createPerson();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error");
        }
        return null;
    }
}
