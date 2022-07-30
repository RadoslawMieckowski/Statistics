package miniLotto.experiments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoGeneratorExperiment {

    public static Set<Integer> generateSearchedSet(String path, int pointer) throws FileNotFoundException, IllegalArgumentException {
        if (pointer < 0) {
            throw new IllegalArgumentException("pointer must not be smaller than 0!");
        }
        Scanner scanner = new Scanner(new File(path));//fajnie było by to refaktorować na BufferedReader z try
        Set<Integer> searchSet = new HashSet<>();
        while (scanner.hasNextLine() && (pointer != 0)) {
            scanner.nextLine();//przewijanie do danego miejsca
            pointer--;
        }
        //odczytanie ramki czasowej
        for (int i = 0; i < 5; i++) {
            if (scanner.hasNextLine()) {
                if (scanner.hasNextInt()) {
                    Arrays.stream(scanner.nextLine().split("\t"))
                            .forEach(number -> searchSet.add(Integer.parseInt(number)));
                }
            }
        }
        scanner.close();
        return searchSet;
    }
}
