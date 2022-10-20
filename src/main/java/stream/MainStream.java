package stream;

public class MainStream {
    final static String PATH = "src/main/java/stream/user.dat";

    public static void main(String[] args) {
        UserDataSaver save = new UserDataSaver();
        save.saveUserData(PATH);

        UserDataReader read = new UserDataReader();
        read.readUserData(PATH);
    }
}
