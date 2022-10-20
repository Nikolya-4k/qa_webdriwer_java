package serializator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("Nikolay", 31, new Pet("Pudge"));

        Serializator serializator = new Serializator();
        serializator.serialize(person);

        Person personData = serializator.deserialize();
        System.out.println("Name: " + personData.getName() + " - " + "Age: " + personData.getAge() + " - " + "Pet name: " + personData.getPet().getName());
    }
}
