package miniLotto.utilities;

import java.util.*;
import java.util.stream.Collectors;

public final class TwoGenerator {
    private TwoGenerator() {}

//    public static List<Two> generateListOfTwos(int[] numbers) {
//        List<Two> list = new LinkedList<>();
//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                list.add(new Two(i, j));
//            }
//        }
//        return list;
//    }

    /**
     * @param numbers   pojedyńcze losowanie w formie tabeli
     * @param mapList
     * @param limitOfEach
     * @param <K>
     * @param <V>
     * @return
     * @throws Throwable
     * generuje listę list dwójek. Dwójki są najbardziej podobne do wszystkich dwójek, które występują w
     * danym zestawie. Określasz, ile ma znaleźć najbardziej podobnych dwójek dla każdej dwójki w kombinacji
     */
    public static <K extends String, V extends Comparable> List<List<Map.Entry<K, V>>> generateListOfTwos(int[] numbers, List<List<Map<K, V>>> mapList, int limitOfEach) throws Throwable {
        //List<Map.Entry<K, V>> listOfEntries = new LinkedList<>();
        List<List<Map.Entry<K, V>>> listOfLists = new LinkedList<>();
        List<Map.Entry<K, V>> listOfFilteredMaps;
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    System.out.println("szukam dla " + numbers[i] + " i " + numbers[j]);
                         listOfFilteredMaps = Finder.filterLargeListOfMapsByFirstAndSecondNumber(
                            String.valueOf(numbers[i]),
                            String.valueOf(numbers[j]),
                            mapList,
                            limitOfEach
                        //    listOfEntries
                    );
                         listOfLists.add(listOfFilteredMaps);//tu dodamy poszczególne wyniki do zwracanej listy
//                    List<Map.Entry<K, V>> listOfMostSimilarEntries =
//                            Finder.findMostSimilarEntriesWithGivenTwo(listOfFilteredMaps, limitOfEach);
//                    listOfLists.add(listOfMostSimilarEntries);
                }
            }
        return listOfLists;
    }
}
