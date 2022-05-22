package miniLotto.utilities;

import lombok.NonNull;

import java.io.*;

public class Serializer {
    private Serializer() {}

    public static <T extends Serializable> void serialize(@NonNull T object, @NonNull String filePath) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(object);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T deserialize(@NonNull String filePath) {
        T retrieveObject = null;
        try(FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            retrieveObject = (T) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return retrieveObject;
    }
}
