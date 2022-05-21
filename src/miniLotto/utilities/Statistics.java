package miniLotto.utilities;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.*;

public class Statistics {
    public static double findMedian(List<Integer> list) {
        list.sort(Comparator.naturalOrder());
        int size = list.size();
        double m;
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
        double m;
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

    public static double cosDistance(List<Integer>list1, List<Integer>list2) {
        int toAdd;
        double cosDistance;
        if(list1.size() < list2.size()) {
            toAdd = list2.size() - list1.size();
            for (int i = 1; i <= toAdd; i++) {
                list1.add(0);    //wyrównanie wymiarów wektorów
            }
        } else {
            toAdd = list1.size() - list2.size();
            for (int i = 1; i <= toAdd; i++) {
                list2.add(0);
            }
        }
        cosDistance = calcCosDistance(list1, list2);
        return cosDistance;
    }

    private static double calcCosDistance(List<Integer> list1, List<Integer>list2) {
        double liczebnik = 0;
        int składnik_mianownika1 = 0;
        int składnik_mianownika2 = 0;
        double pierwiastek1;
        double pierwiastek2;
        double mianownik;
        double cosDistance;

        for (int i = 0; i < list1.size(); i++) {
            liczebnik += (list1.get(i) * list2.get(i));
            składnik_mianownika1 +=  list1.get(i);
            składnik_mianownika2 +=  list2.get(i);
        }
        pierwiastek1 = sqrt(składnik_mianownika1);
        pierwiastek2 = sqrt(składnik_mianownika2);
        mianownik = pierwiastek1 + pierwiastek2;
        cosDistance = liczebnik / mianownik;
        return cosDistance;
    }

    public static void main(String[] args) {
        List<Integer> listEven = new LinkedList<>(List.of(1, 2, 3, 4));
        System.out.println(findQ3(listEven));
        List<Integer> listOdd = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(findQ3(listOdd));
    }
}
