package miniLotto.demos;

import miniLotto.models.Two;
import miniLotto.utilities.Filter;
import miniLotto.utilities.Presenter;
import miniLotto.utilities.Serializer;

import java.util.List;

public class FilterDemo {
    public static void main(String[] args) {
        List<Two> deserializedList = Serializer.deserialize("src/main/resources/Twos_serialized.ser");

       /* List<Two> filteredList1 = Filter.filterTwosWithLastBiggerthanMed(deserializedList);
        System.out.println("LastBiggerthanMed\tSize: " + filteredList1.size() + "\n"
                + Presenter.present(filteredList1) + "\n");
        System.out.println("============================================================================");
*//*
        List<Two> filteredList2 = Filter.filterTwosWithLastBiggerthan3Q(deserializedList);
        System.out.println("LastBiggerthan3Q\tSize: " + filteredList2.size()+ "\n"
                + Presenter.present(filteredList2) + "\n");
        System.out.println("============================================================================");*/

       /* List<Two> filteredList3 = Filter.filterTwosWithLastLessthanMed(deserializedList);
        System.out.println("LastLessthanMed\tSize: " + filteredList3.size()+ "\n"
                + Presenter.present(filteredList3) + "\n");
        System.out.println("============================================================================");*/

        List<Two> filteredList4 = Filter.filterTwosWithLastLessthan3Q(deserializedList);
        System.out.println("LastLessthan3Q\tSize: " + filteredList4.size()+ "\n"
                + Presenter.presentList(filteredList4) + "\n");
        System.out.println("============================================================================");
        //zrób unit testy
    }
}
