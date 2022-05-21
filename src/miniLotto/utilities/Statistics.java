package miniLotto.utilities;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Statistics {
    public static double findMedian(List<Integer> list) {
        list.sort(Comparator.naturalOrder());
        int size = list.size();
        double m = 0;
        if(size % 2 == 1)
        {
            m = list.get((size+1)/2-1);
        }
        else
        {
            m = (list.get(size/2-1) + list.get(size/2))/2;
        }
        return m;
    }

    public static double findQ3(List<Integer> list) {
        list.sort(Comparator.naturalOrder());
        int size = list.size();
        double m = 0;
        if(size % 2 == 1)
        {
            m = list.get(3 * (size+1)/4 - 1);
        }
        else
        {
            m = (list.get(3 * size/4 - 1) + list.get(3 * size/4))/2;
        }
        return m;
    }

    public static void cosSimiliarity() {

    }

    public static void main(String[] args) {
        List<Integer> listEven = new LinkedList<>(List.of(1, 2, 3, 4));
        System.out.println(findQ3(listEven));
        List<Integer> listOdd = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(findQ3(listOdd));
    }
}
