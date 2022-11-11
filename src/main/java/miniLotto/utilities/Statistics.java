package miniLotto.utilities;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public final class Statistics {
    public static double findMedian(List<Integer> list) {
        //można też tak: List<Integer> copyList = new LinkedList<>(list);
        List<Integer> copyList = list.stream().collect(Collectors.toList());
        copyList.sort(Comparator.naturalOrder());
        int size = copyList.size();
        double m;
        if(size % 2 == 1)
        {
            m = copyList.get((size+1)/2-1);
        }
        else
        {
            m =(copyList.get(size/2-1) + copyList.get(size/2))/2.;//albo (double)
        }
        return m;
    }

    public static double findQ3(List<Integer> list) {
        List<Integer> copyList = list.stream().collect(Collectors.toList());
        copyList.sort(Comparator.naturalOrder());
        int size = copyList.size();
        double m;
        if(size % 2 == 1)
        {
            int afterMedianIndex = copyList.size() / 2 + 1;
            List<Integer> sublist = copyList.subList(afterMedianIndex, copyList.size());
            m = findMedian(sublist);
        }
        else
        {
            m = (copyList.get((int)(3 * size/4. - 1)) + copyList.get((int)((3 * size + 4)/4.)))/2.;
        }
        return m;
    }

    public static double cosDistance(List<Integer>list1, List<Integer>list2) {
        List<Integer> copyList1 = list1.stream().collect(Collectors.toList());
        List<Integer> copyList2 = list2.stream().collect(Collectors.toList());
        int toAdd;
        double cosDistance;
        if(copyList1.size() < copyList2.size()) {
            toAdd = copyList2.size() - copyList1.size();
            for (int i = 1; i <= toAdd; i++) {
                copyList1.add(0);    //wyrównanie wymiarów wektorów
            }
        } else {
            toAdd = copyList1.size() - copyList2.size();
            for (int i = 1; i <= toAdd; i++) {
                copyList2.add(0);
            }
        }
        cosDistance = calcCosDistance(copyList1, copyList2);
        return cosDistance;
    }

    private static double calcCosDistance(List<Integer> list1, List<Integer>list2) {
        double liczebnik = 0;
        int czynnik_mianownika1 = 0;
        int czynnik_mianownika2 = 0;
        double pierwiastek1;
        double pierwiastek2;
        double mianownik;
        double cosDistance;

        for (int i = 0; i < list1.size(); i++) {
            liczebnik += (list1.get(i) * list2.get(i));
            czynnik_mianownika1 +=  pow(list1.get(i), 2);
            czynnik_mianownika2 +=  pow(list2.get(i), 2);
        }
        pierwiastek1 = sqrt(czynnik_mianownika1);
        pierwiastek2 = sqrt(czynnik_mianownika2);
        mianownik = pierwiastek1 * pierwiastek2;
        cosDistance = liczebnik / mianownik;
        return cosDistance;
    }

    public static void showStatistics(LinkedList<Integer> distances) {
        System.out.println("interwały znalezionych przypadków: ");
        System.out.println(distances);
        double median = Statistics.findMedian(distances);
        System.out.println("Mediana zbioru: " + median);
        double q3 = Statistics.findQ3(distances);
        System.out.println("Trzeci kwantyl zbioru: " + q3);
        double lastOccurence = distances.getLast();// zależy nam na ostatnim przypadku nieposortowanego zbioru
        System.out.println("Ostatni przypadek: " + lastOccurence);
        double avg = distances.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        System.out.println("Średni interwał: " + avg);
        System.out.println("posortowane interwały znalezionych przypadków: ");
        List<Integer> winningDistancesCopy = new ArrayList<>(distances);
        Collections.sort(winningDistancesCopy);
        System.out.println(winningDistancesCopy);
    }
}
