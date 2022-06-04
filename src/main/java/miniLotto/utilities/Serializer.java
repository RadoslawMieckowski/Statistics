package miniLotto.utilities;

import lombok.NonNull;

import java.io.*;
import java.util.Map;

public class Serializer {
    private Serializer() {}

    public static <T extends Serializable> void serialize(@NonNull T object, @NonNull String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
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
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            retrieveObject = (T) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return retrieveObject;
    }

    public static <K, V> void serializeMap(@NonNull Map<K, V> map, @NonNull String filePath) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <K, V> Map<K, V> deserializeMap(@NonNull String filePath) {
        Map<K, V> map= null;
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            map = (Map<K, V>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }
}
