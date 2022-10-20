package stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserDataReader {
    public void readUserData(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                String text = reader.readLine();
                System.out.println(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
