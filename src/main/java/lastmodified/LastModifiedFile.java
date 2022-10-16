package lastmodified;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class LastModifiedFile {
    public static void main(String[] args) {
        String path = "src/main/resources/testdata/";
        String fileName = "test_data.yaml";

        checkDirectory(path);
        checkFile(path, fileName);
        lastModifiedFile(path, fileName);
    }

    public static void checkDirectory(String path) {
        File directory = new File(path);

        try {
            if (!directory.exists()) {
                directory.mkdirs();
                System.out.println("Directory created: " + directory.getName());
            } else {
                System.out.println("Directory already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void checkFile(String path, String name) {
        File directory = new File(path);
        File file = new File(directory, name);

        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void lastModifiedFile(String path, String name) {
        File file = new File(path, name);
        SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
        System.out.println("File was last modified " + date.format(file.lastModified()));
    }
}
