package miniLotto.utilities;

import java.util.Collections;
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
            m = (double)(list.get(size/2-1) + list.get(size/2))/2;
        }
        return m;
    }

   /* public static void main(String[] args) {
        List<Integer> listEven = new LinkedList<>(List.of(4, 2, 6, 0, 1, 3));
        System.out.println(findMedian(listEven));
        List<Integer> listOdd = new LinkedList<>(List.of(4, 2, 6, 0, 1, 3, 5));
        System.out.println(findMedian(listOdd));
    }*/
}
