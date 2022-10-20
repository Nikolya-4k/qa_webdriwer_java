package stream;

import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import static org.testng.AssertJUnit.assertEquals;

public class UserDataSaver {
    public void saveUserData(String path) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equalsIgnoreCase("exit")) {
            input = scanner.nextLine();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
                if (input.equalsIgnoreCase("write")) {
                    writer.flush();
                }
                writer.write(input);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}
