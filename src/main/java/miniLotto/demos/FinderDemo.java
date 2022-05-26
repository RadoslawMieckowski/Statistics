package miniLotto.demos;

import miniLotto.models.Two;
import miniLotto.utilities.Filter;
import miniLotto.utilities.Finder;
import miniLotto.utilities.Serializer;

import java.util.List;

public class FinderDemo {
    public static void main(String[] args) {
        List<Two> deserializedList = Serializer.deserialize("src/main/resources/Twos_serialized.ser");
        Two pair = Finder.findTwoWithMaxLastOccurence(Filter.filterTwosWithLastBiggerthan3Q(deserializedList));
        System.out.println(pair);
    }
}
