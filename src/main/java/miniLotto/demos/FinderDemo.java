package miniLotto.demos;

import miniLotto.models.Two;
import miniLotto.utilities.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FinderDemo {
    public static void main(String[] args) {
        List<Two> deserializedList = Serializer.deserialize("src/main/resources/Twos_serialized.ser");
        //Two pair = Finder.findTwoWithMaxLastOccurence(Filter.filterTwosWithLastBiggerthan3Q(deserializedList));
        //System.out.println(pair);
        //zrób sobie plik .sh baszowy, który będzie odpalał sekwencyjnie np TwosFrequency, Finder.java itp, żeby zautomatyzować proces wydobywania wiedzy
//        List<Two> twosWithLastBiggerThan3QSortedByLast = Filter.filterTwosWithLastBiggerthan3Q(deserializedList);
//        Sorter.sortByMaxInterval(twosWithLastBiggerThan3QSortedByLast);
//        System.out.println("Długość listy: " + twosWithLastBiggerThan3QSortedByLast.size());
//        System.out.println(Presenter.presentList(twosWithLastBiggerThan3QSortedByLast));

        //dla dwójki o najmniejszej 3q szukamy najbardziej podobnej dwójki
        Two twoWithMinMedian = Finder.findTwoWithMinMedOfintervals(deserializedList);
        System.out.println("minimalna mediana\n" + twoWithMinMedian + "\n");
        Two twoWithMin3Q = Finder.findTwoWithMinQ3Ofintervals(deserializedList);
        System.out.println("minimalny trzeci kwartyl\n" + twoWithMin3Q);
        List<Map<String, Double>> listOfSimilarities = Serializer.deserializeListOfMaps(
                "src/main/resources/list_of_mapped_distances.ser");
        List<Map.Entry<String, Double>> filteredMap = Finder.filterListOfMapsByFirstAndSecondNumber(
                String.valueOf(twoWithMin3Q.getFirstNumber()),
                String.valueOf(twoWithMin3Q.getSecondNumber()),
                listOfSimilarities
                );
    }
}
