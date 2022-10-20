package serializator;

import java.io.*;

public class Serializator {
    private static final File DATA = new File("src/main/java/serializator/person.dat");

    public boolean serialize(Person person) {
        boolean flag = false;

        try (FileOutputStream fileOutput = new FileOutputStream(DATA);
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {
            objectOutput.writeObject(person);
            System.out.println("Person serialized");
            flag = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Person deserialize() throws IOException, ClassNotFoundException {
        Person person = null;
        FileInputStream inputFile = new FileInputStream(DATA);
        ObjectInputStream inputObject = new ObjectInputStream(inputFile);

        person = (Person) inputObject.readObject();

        System.out.println("Person deserialized");
        return person;
    }
}
