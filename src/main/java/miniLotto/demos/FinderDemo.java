package miniLotto.demos;

import miniLotto.models.Two;
import miniLotto.utilities.*;

import java.util.List;

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
        Two twoWithMinMedian = Finder.findTwoWithMinMedOfintervals(deserializedList);
        System.out.println("minimalna mediana\n" + twoWithMinMedian + "\n");
        Two twoWithMin3Q = Finder.findTwoWithMinQ3Ofintervals(deserializedList);
        System.out.println("minimalny trzeci kwartyl\n" + twoWithMin3Q);
    }
}
