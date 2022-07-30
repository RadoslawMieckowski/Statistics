package miniLotto.experiments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public final class TwoGeneratorExperiment {

private TwoGeneratorExperiment() {}

    //jak chcę do linijki nr 100 włącznie, powinieniem przewinąć na 95 linie, czyli przekazać 95
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

    //jeżeli chcesz mieć sety wygenerowane na podstawie 100 linii, musisz przekazać 100 jako parametr
    public static List<Set<Integer>> generateSearchedSetsToGivenPointInCSVFile(int numberOfNotEmptyLines, String path) throws FileNotFoundException {
        int value = numberOfNotEmptyLines - 5;
        List<Set<Integer>> listOfSets = new ArrayList<>(value);
        final int RECORDS_INTO_ACCOUNT = value;//na tej linii ostatnia piątka
        while (value >= 0) {
            Set<Integer> actualSet = TwoGeneratorExperiment.generateSearchedSet(
                    path,
                    RECORDS_INTO_ACCOUNT - value);
            listOfSets.add(actualSet);
//            System.out.println("index:" + (listOfSets.size()-1) + actualSet);
            value--;
        }
        return listOfSets;
    }
}
