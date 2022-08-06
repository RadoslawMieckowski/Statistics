package miniLotto.experiments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class TwoGeneratorExperiment {

private TwoGeneratorExperiment() {}

    //jak chcę do linijki nr 100 włącznie, powinieniem przewinąć na 95 linie, czyli przekazać 95
    //PAMIĘNTAJ: szukany set NIE powinien uwzględniać poprzedniego losowania, więc najlepiej wywołaniu tej metody po prostu usuń pierwszy element
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

    //4|19 i 14|30
    //4|19 i 7|33

    //generuje zbiór liczb bez liczb z zadanego losowania
    public static <K extends String, V extends Comparable> Set<Integer> generateProposedBroadSet(List<List<Map.Entry<K, V>>> list, int[] previousDraw) {
        List<Integer> broadProposedList = new LinkedList<>();
        list.stream().flatMap(List::stream)//   OK  .forEach(System.out::println);
                .forEach(entry -> parse(entry.getKey(), broadProposedList));
        //System.out.println("broadProposedList: " + broadProposedList);

        Set<Integer> previousDrawSet = new HashSet<>();
        Set<Integer> finalPreviousDrawSet = previousDrawSet;//kompilator skuczał, żeby tak zrobić
        Arrays.stream(previousDraw).forEach(e -> finalPreviousDrawSet.add(Integer.valueOf(e)));
        broadProposedList.removeAll(previousDrawSet);

        Map<Integer, Long> numbersMap = broadProposedList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
         return numbersMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

//2|17 i 10|23
    //wyciąga z dostarczonego stringa liczby i umieszcza je w dostarczonej liście
    public static <V> void parse(String line, List<V> list) {
        String[] array = line.split(" i ");
        Arrays.stream(array)
                .forEach(e ->
                        Arrays.stream(e.split("\\|")).map(Integer::valueOf).forEach(x -> list.add((V)x)));
    }
}
