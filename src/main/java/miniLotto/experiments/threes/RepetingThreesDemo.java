package miniLotto.experiments.threes;

import miniLotto.utilities.Presenter;
import miniLotto.utilities.Serializer;

import java.util.List;

public class RepetingThreesDemo {
    public static void main(String[] args) {
        //rozpakowanie list
        List<int[]> oldTabsList = Serializer.deserialize("src/main/resources/oldTabListToSerialize.ser");
        List<int[]> newTabsList = Serializer.deserialize("src/main/resources/newTabListToSerialize.ser");
        System.out.println("oldTabsList's size: " + oldTabsList.size() + "\noldTabsList:");
        Presenter.presentListOfIntTables(oldTabsList);
        System.out.println("newTabsList's size: " + newTabsList.size() + "\nnewTabsList:");// jest 60 zapisów: [8, 14, 15, 37, 38]
        Presenter.presentListOfIntTables(newTabsList);
    }
}
