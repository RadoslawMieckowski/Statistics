package miniLotto.experiments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoGeneratorExperiment {
    public static void main(String[] args) {
        //odczytanie ramki czasowej
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/wyniki-minilotto-sortowane100.csv"));
            if (scanner.hasNext()) {
                if (scanner.hasNextLine()) {
                    Set<Integer> searchSet = new HashSet<>();
                    for (int i = 0; i < 5; i++) {
                        Arrays.stream(scanner.nextLine().split("\t"))
                                .forEach(number -> searchSet.add(Integer.parseInt(number)));

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
